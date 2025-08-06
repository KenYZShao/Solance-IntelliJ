package com.solance.repository;

import com.solance.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {
    // 添加Optional返回类型
    Optional<Account> findByIban(String iban);
}