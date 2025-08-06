package com.solance.domain;

public enum TransactionStatus {
    PENDING,      // 交易已创建但未处理
    PROCESSED,    // 交易已成功处理
    FAILED,       // 交易处理失败
    REVERSED,     // 交易已撤销
    CANCELLED     // 交易已取消
}