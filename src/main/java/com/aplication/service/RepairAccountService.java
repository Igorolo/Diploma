package com.aplication.service;

import com.aplication.entity.Account;
import com.aplication.entity.Repair;
import com.aplication.entity.RepairAccount;
import com.aplication.exceptions.AccountNotFoundException;
import com.aplication.exceptions.RepairAccountNotFoundException;
import com.aplication.exceptions.RepairNotFoundException;
import com.aplication.repository.AccountRepository;
import com.aplication.repository.RepairAccountRepository;
import com.aplication.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class RepairAccountService {
    private final RepairAccountRepository repairAccountRepository;
    private final RepairRepository repairRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public RepairAccountService(RepairAccountRepository repairAccountRepository, RepairRepository repairRepository, AccountRepository accountRepository) {
        this.repairAccountRepository = repairAccountRepository;
        this.repairRepository = repairRepository;
        this.accountRepository = accountRepository;
    }

    public Long createRepairAccount(Long repairId, Long accountId, Date date, String repairName) {
        Optional<Repair> repairOptional = repairRepository.findById(repairId);
        Repair repair = repairOptional.orElseThrow(() -> new RepairNotFoundException("Unable to find repair with id " + repairId));

        Optional<Account> accountOptional = accountRepository.findById(accountId);
        Account account = accountOptional.orElseThrow(() -> new AccountNotFoundException("Unable to find account with id " + accountId));

        RepairAccount repairAccount = new RepairAccount(repair, account, date, repairName);
        RepairAccount savedRepairAccount = repairAccountRepository.save(repairAccount);
        return savedRepairAccount.getId();
    }

    public RepairAccount getById(Long repairAccountId) {
        return repairAccountRepository.findById(repairAccountId)
                .orElseThrow(() -> new RepairAccountNotFoundException("Unable to find RepairAccount with id " + repairAccountId));
    }

    public void deleteById(Long repairAccountId) {
        repairAccountRepository.deleteById(repairAccountId);
    }
}
