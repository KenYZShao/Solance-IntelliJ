package com.solance.domain;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
//import org.springframework.data.annotation.Id;

import java.math.BigDecimal;



// Account.java
@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String iban; // Use UUID-based IBAN
    @ManyToOne
    private Customer customer;
    private String currency;
    private String accountHolder;
    private BigDecimal balance = BigDecimal.ZERO;
    //private AccountStatus status = AccountStatus.ACTIVE;
    @Enumerated(EnumType.STRING) // Store enum as string in DB
    private AccountStatus status = AccountStatus.ACTIVE;
}

