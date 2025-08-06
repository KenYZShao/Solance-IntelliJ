package com.solance.service;

import com.solance.domain.Account;
import com.solance.domain.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class AsyncService {
    private static final Logger logger = LoggerFactory.getLogger(AsyncService.class);

    @Async
    public void performAsyncTask() {
        logger.info("Starting async task...");
        try {
            // 模拟长时间任务
            Thread.sleep(5000);
            logger.info("Async task completed successfully");
        } catch (InterruptedException e) {
            logger.error("Async task interrupted", e);
            Thread.currentThread().interrupt();
        }
    }
    @Async
    public void auditLog(Transaction transaction) {  // 确保参数是 Transaction 类型
        logger.info("Audit log for transaction: {}", transaction.getId());
        // 实现逻辑...
    }
    // 添加通知方法
    @Async
    public void sendNotification(Account account, Transaction transaction) {
        logger.info("Sending notification for account: {}", account.getId());
        // 实现通知逻辑
    }

    // 添加数据同步方法
    @Async
    public void syncToDataWarehouse(Transaction transaction) {
        logger.info("Syncing transaction to data warehouse: {}", transaction.getId());
        // 实现数据同步逻辑
    }

}