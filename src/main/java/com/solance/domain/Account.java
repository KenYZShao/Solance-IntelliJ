package com.solance.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import jakarta.persistence.Entity;



// Account.java
@Entity
@Data
public class Account {
    @Id
    private String iban; // Use UUID-based IBAN
    @ManyToOne
    private Customer customer;
    private String currency;
    private BigDecimal balance = BigDecimal.ZERO;
    //private AccountStatus status = AccountStatus.ACTIVE;
    @Enumerated(EnumType.STRING) // Store enum as string in DB
    private AccountStatus status = AccountStatus.ACTIVE;
}

