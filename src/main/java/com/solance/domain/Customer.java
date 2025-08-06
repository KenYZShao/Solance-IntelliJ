package com.solance.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import lombok.Data;
//import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

// Customer.java
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String address;
    private String countryCode;
    private LocalDateTime registrationDate = LocalDateTime.now();
}