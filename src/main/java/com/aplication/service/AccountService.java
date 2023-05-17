package com.aplication.service;

import com.aplication.controller.dto.CityRequestDTO;
import com.aplication.entity.Account;
import com.aplication.entity.City;
import com.aplication.exceptions.AccountNotFoundException;
import com.aplication.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Long createAccount(String fullName, String phoneNumber, String email, String login, String password, Boolean isAdmin, City city) {
        Account account = new Account(fullName, phoneNumber, email, login, password, isAdmin, city);
        Account createdAccount = accountRepository.save(account);
        return createdAccount.getAccountId();
    }

    public Account getAccountById(Long accountId) {
        Optional<Account> accountOptional = accountRepository.findById(accountId);
        return accountOptional.orElseThrow(() -> new AccountNotFoundException("Unable to find account with id " + accountId));
    }

    public Account getAccountByLogin(String login) {
        Optional<Account> accountOptional = accountRepository.findByLogin(login);
        return accountOptional.orElseThrow(() -> new AccountNotFoundException("Unable to find account with login " + login));
    }

    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }

    public Long createAccountFromDTO(String fullName, String phoneNumber, String email, String login, String password, Boolean isAdmin, CityRequestDTO cityDTO) {
        // Преобразование объекта CityRequestDTO в City
        City city = convertCityDTOtoCity(cityDTO);

        // Вызов метода createAccount с преобразованными данными
        return createAccount(fullName, phoneNumber, email, login, password, isAdmin, city);
    }

    public City convertCityDTOtoCity(CityRequestDTO cityDTO) {
        City city = new City();
        city.setCountry(cityDTO.getCountry());
        city.setCity(cityDTO.getCity());
        return city;
    }
}

