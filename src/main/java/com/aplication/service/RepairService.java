package com.aplication.service;

import com.aplication.entity.Account;
import com.aplication.entity.City;
import com.aplication.entity.Repair;
import com.aplication.exceptions.AccountNotFoundException;
import com.aplication.exceptions.CityNotFoundException;
import com.aplication.exceptions.RepairNotFoundException;
import com.aplication.repository.AccountRepository;
import com.aplication.repository.CityRepository;
import com.aplication.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepairService {
    private final RepairRepository repairRepository;
    private final AccountRepository accountRepository;
    private final CityRepository cityRepository;

    @Autowired
    public RepairService(RepairRepository repairRepository, AccountRepository accountRepository, CityRepository cityRepository) {
        this.repairRepository = repairRepository;
        this.accountRepository = accountRepository;
        this.cityRepository = cityRepository;
    }

    public Long save(String name, String address, String workingSchedule, Float rating, Long cityId) {
        Optional<City> cityOptional = cityRepository.findById(cityId);
        City city = cityOptional.orElseThrow(() -> new CityNotFoundException("Unable to find city with id " + cityId));

        Repair repair = new Repair(name, address, workingSchedule, rating, city);
        Repair savedRepair = repairRepository.save(repair);
        return savedRepair.getRepairId();
    }

    public Repair getById(Long repairId) {
        return repairRepository.findById(repairId)
                .orElseThrow(() -> new RepairNotFoundException("Unable to find repair with id " + repairId));
    }


    public void deleteById(Long repairId) {
        repairRepository.deleteById(repairId);
    }

    public void addAccountToRepair(Long accountId, Long repairId) {
        Optional<Account> accountOptional = accountRepository.findById(accountId);
        Account account = accountOptional.orElseThrow(() -> new AccountNotFoundException("Unable to find account with id " + accountId));

        Optional<Repair> repairOptional = repairRepository.findById(repairId);
        Repair repair = repairOptional.orElseThrow(() -> new RepairNotFoundException("Unable to find repair with id " + repairId));

        repair.addAccount(account);
        repairRepository.save(repair);
    }

    public void removeAccountFromRepair(Long accountId, Long repairId) {
        Optional<Account> accountOptional = accountRepository.findById(accountId);
        Account account = accountOptional.orElseThrow(() -> new AccountNotFoundException("Unable to find account with id " + accountId));

        Optional<Repair> repairOptional = repairRepository.findById(repairId);
        Repair repair = repairOptional.orElseThrow(() -> new RepairNotFoundException("Unable to find repair with id " + repairId));

        repair.removeAccount(account);
        repairRepository.save(repair);
    }
}
