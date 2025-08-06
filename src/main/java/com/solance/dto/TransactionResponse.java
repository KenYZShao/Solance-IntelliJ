package com.solance.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionResponse {
    private Long id;
    private BigDecimal amount;
    private String currency;
    private LocalDateTime timestamp;
    private String status;

    // 支付指令特有字段
    private String beneficiaryIban;
    private String originatingCountry;
    private String paymentReference;
    private String purposeReference;
    private BigDecimal exchangeRate;
    private String targetCurrency;

    // 手动添加 getter/setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // 为所有字段重复此模式...
    // 包括 amount, currency, timestamp, status 等

    public String getBeneficiaryIban() {
        return beneficiaryIban;
    }

    public void setBeneficiaryIban(String beneficiaryIban) {
        this.beneficiaryIban = beneficiaryIban;
    }

}