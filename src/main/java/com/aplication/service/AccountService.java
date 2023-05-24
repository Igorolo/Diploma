package com.aplication.service;

import com.aplication.controller.dto.CityRequestDTO;
import com.aplication.entity.Account;
import com.aplication.entity.City;
import com.aplication.exceptions.AccountNotFoundException;
import com.aplication.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Long createAccount(String fullName, String phoneNumber, String email, String login, String password, City city) {
        Optional<Account> existingAccountOptional = accountRepository.findByLogin(login);
        if (existingAccountOptional.isPresent()) {
            throw new IllegalArgumentException("Account with the given login already exists");
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);

        Account account = new Account(fullName, phoneNumber, email, login, encodedPassword, city);
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

    public Account getAccountByLoginAndPassword(String login, String password){
        Optional<Account> accountOptional = accountRepository.findByLoginAndPassword(login, password);
        return accountOptional.orElseThrow(() -> new AccountNotFoundException("Incorrect login or password "));
    }

    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }

    public Long createAccountFromDTO(String fullName, String phoneNumber, String email, String login, String password,
                                     Boolean isAdmin, CityRequestDTO cityDTO) {
        // Преобразование объекта CityRequestDTO в City
        City city = convertCityDTOtoCity(cityDTO);

        // Вызов метода createAccount с преобразованными данными
        return createAccount(fullName, phoneNumber, email, login, password, city);
    }

    /*public String getAccountFullName(Long id){
         return accountRepository.findFullName(id);
    }*/

    public City convertCityDTOtoCity(CityRequestDTO cityDTO) {
        City city = new City();
        city.setCountry(cityDTO.getCountry());
        city.setCity(cityDTO.getCity());
        return city;
    }
}

