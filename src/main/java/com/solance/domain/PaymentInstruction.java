package com.solance.domain;

import com.solance.domain.Transaction;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

// PaymentInstruction.java

@Entity
@DiscriminatorValue("PAYMENT")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PaymentInstruction extends Transaction {
    private String beneficiaryIban;
    private String originatingCountry;
    private String paymentReference;
    private String purposeReference;
    private BigDecimal exchangeRate;
    private String targetCurrency;

    // 确保有这些 getter 方法
    public String getBeneficiaryIban() {
        return beneficiaryIban;
    }

    public String getOriginatingCountry() {
        return originatingCountry;
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public String getPurposeReference() {
        return purposeReference;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }
}