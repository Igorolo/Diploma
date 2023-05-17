package com.aplication.repository;

import com.aplication.entity.TestAccount;
import com.aplication.entity.TestAccountKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestAccountRepository extends JpaRepository<TestAccount, TestAccountKey> {
}
