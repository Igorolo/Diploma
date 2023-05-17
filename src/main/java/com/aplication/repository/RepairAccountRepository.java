package com.aplication.repository;

import com.aplication.entity.RepairAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairAccountRepository extends JpaRepository<RepairAccount, Long> {
}
