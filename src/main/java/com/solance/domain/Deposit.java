package com.solance.domain;

import com.solance.domain.Transaction;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

// Deposit.java
@Entity
@DiscriminatorValue("DEPOSIT")
public class Deposit extends Transaction {
    private String reference;
}