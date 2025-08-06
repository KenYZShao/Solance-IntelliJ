package com.solance.repository;

import com.solance.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value = "SELECT t FROM Transaction t ORDER BY t.timestamp DESC LIMIT 50")
    List<Transaction> findRecentTransactions();

    // You can add other query methods later:
    // List<Transaction> findByAccount_Iban(String iban);
    // List<Transaction> findByStatus(TransactionStatus status);
}