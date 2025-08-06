package com.solance.service.mapper;

import com.solance.domain.PaymentInstruction;
import com.solance.domain.TransactionStatus;
import com.solance.dto.PaymentRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.Optional;

@Component
public class TransactionMapper {

    public PaymentInstruction mapToEntity(PaymentRequest request) {
        return PaymentInstruction.builder()
                .amount(getSafeBigDecimal(request.getAmountSell()))
                .currency(request.getCurrencyFrom())
                .timestamp(LocalDateTime.now())
                .status(TransactionStatus.PENDING)
                .beneficiaryIban(request.getBeneficiaryIban())
                .originatingCountry(request.getOriginatingCountry())
                .paymentReference(request.getPaymentReference())
                .purposeReference(request.getPurposeReference())
                .exchangeRate(getSafeBigDecimal(request.getRate()))
                .targetCurrency(request.getCurrencyTo())
                .build();
    }

    private BigDecimal getSafeBigDecimal(BigDecimal value) {
        return Optional.ofNullable(value).orElse(BigDecimal.ZERO);
    }
}