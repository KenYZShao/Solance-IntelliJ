package com.solance.web;

import com.solance.domain.Transaction;
import com.solance.dto.PaymentRequest; // 修复1：导入正确的PaymentRequest
import com.solance.dto.TransactionResponse; // 修复2：导入TransactionResponse
import com.solance.service.WorkflowService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.solance.domain.PaymentInstruction;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/workflow")
@RequiredArgsConstructor
public class WorkflowController { // 修复3：移除泛型<TransactionResponse>

    private final WorkflowService workflowService;

    @PostMapping("/payment")
    public ResponseEntity<TransactionResponse> createPayment( // 修复4：移除方法泛型
                                                              @Valid @RequestBody PaymentRequest request) { // 使用具体的PaymentRequest类型
        Transaction txn = workflowService.processPayment(request);
        return ResponseEntity.ok(mapToDto(txn));
    }

    // 实现mapToDto方法
    private TransactionResponse mapToDto(Transaction txn) {
        TransactionResponse response = new TransactionResponse();
        // 设置基础字段
        response.setId(txn.getId());
        response.setAmount(txn.getAmount());
        response.setCurrency(txn.getCurrency());
        response.setTimestamp(txn.getTimestamp());
        response.setStatus(txn.getStatus().toString());

        // 如果是PaymentInstruction类型，设置特有字段
        if (txn instanceof PaymentInstruction) {
            PaymentInstruction payment = (PaymentInstruction) txn;
            response.setBeneficiaryIban(payment.getBeneficiaryIban());
            response.setOriginatingCountry(payment.getOriginatingCountry());
            response.setPaymentReference(payment.getPaymentReference());
            response.setPurposeReference(payment.getPurposeReference());
            response.setExchangeRate(payment.getExchangeRate());
            response.setTargetCurrency(payment.getTargetCurrency());
        }

        return response;
    }

    @GetMapping("/transactions")
    public ResponseEntity<List<TransactionResponse>> getRecentTransactions() {
        List<Transaction> transactions = workflowService.getRecentTransactions();

        // 使用stream转换实体为DTO
        List<TransactionResponse> responseList = transactions.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responseList);
    }
}