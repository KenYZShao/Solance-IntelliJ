package com.solance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import jakarta.validation.constraints.*;
import lombok.Getter;

import java.math.BigDecimal;

@Data
@Getter // 显式添加这个注解
public class PaymentRequest {

    // 新增以下字段
    @NotBlank
    private String sourceIban; // 付款账户IBAN

    @NotBlank
    private String userId;

    @Positive
    private BigDecimal amount;

    @Pattern(regexp = "^[A-Z]{3}$")
    private String currency;

    @NotBlank
    @JsonProperty("Solance From") // 匹配JSON字段名
    private String currencyFrom;

    @NotBlank
    @JsonProperty("Solance To")
    private String currencyTo;

    @Positive
    private BigDecimal amountSell;

    @Positive
    private BigDecimal amountBuy;

    @Positive
    private BigDecimal rate;

    @NotBlank
    private String timePlaced;

    @NotBlank
    @JsonProperty("beneficiary IBAN") // 匹配JSON字段名
    private String beneficiaryIban;

    @NotBlank
    private String originatingCountry;

    @NotBlank
    @JsonProperty("paymentRef") // 匹配JSON字段名
    private String paymentReference;

    @NotBlank
    @JsonProperty("purposeRef") // 匹配JSON字段名
    private String purposeReference;


    // === 添加完整 getter/setter ===
    public String getSourceIban() {
        return sourceIban;
    }

    public void setSourceIban(String sourceIban) {
        this.sourceIban = sourceIban;
    }

    public BigDecimal getAmountSell() {
        return amountSell;
    }

    public void setAmountSell(BigDecimal amountSell) {
        this.amountSell = amountSell;
    }

    // 其他字段的 getter/setter...
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    }


