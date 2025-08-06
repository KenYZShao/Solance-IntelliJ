package com.solance.service;

import com.solance.domain.Account;
import com.solance.domain.PaymentInstruction;
import com.solance.domain.Transaction;
import com.solance.domain.TransactionStatus;
import com.solance.dto.PaymentRequest;
import com.solance.exception.AccountNotFoundException; // 修复1：自定义异常
import com.solance.exception.InsufficientBalanceException;
import com.solance.repository.AccountRepository;
import com.solance.repository.TransactionRepository;
import com.solance.service.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service // 修复2：只保留@Service
@RequiredArgsConstructor
public class WorkflowService { // 修复3：移除泛型<PaymentRequest>

    private final AsyncService asyncService; // 注入异步服务
    private final AccountRepository accountRepo;
    private final TransactionRepository txnRepo;
    private final TransactionMapper transactionMapper;

    @Cacheable(value = "accounts", key = "#iban")
    public Account getAccountByIban(String iban) {
        return accountRepo.findByIban(iban)
                .orElseThrow(() -> new AccountNotFoundException("Account not found for IBAN: " + iban));
    }


    @Transactional
    public Transaction processPayment(PaymentRequest request) {
        // 1. 获取源账户
       // Account account = accountRepo.findByIban(request.getSourceIban())
         //       .orElseThrow(() -> new AccountNotFoundException("Account not found"));
        Account account = getAccountByIban(request.getSourceIban());
        // 2. 检查余额
        PaymentInstruction payment = transactionMapper.mapToEntity(request);
        Transaction savedTxn = txnRepo.save(payment);
        BigDecimal amountSell = Optional.ofNullable(request.getAmountSell())
                .orElse(BigDecimal.ZERO);

        if (account.getBalance().compareTo(amountSell) < 0) {
            throw new InsufficientBalanceException("Insufficient funds");
        }

        // 3. 创建支付指令
        //PaymentInstruction payment = transactionMapper.mapToEntity(request);
        payment.setStatus(TransactionStatus.PROCESSED);

        // 4. 更新账户余额
        account.setBalance(account.getBalance().subtract(amountSell));
        accountRepo.save(account);

        // 异步调用非关键操作
        asyncService.auditLog(savedTxn);          // 审计日志
        asyncService.sendNotification(account, savedTxn); // 通知
        asyncService.syncToDataWarehouse(savedTxn); // 数据同步

        // 5. 保存交易
        return txnRepo.save(payment);
    }

    public List<Transaction> getRecentTransactions() {
        return txnRepo.findRecentTransactions();
    }
}