package com.aplication.controller;

import com.aplication.controller.dto.AccountRequestDTO;
import com.aplication.controller.dto.AccountResponseDTO;
import com.aplication.controller.dto.CityRequestDTO;
import com.aplication.entity.City;
import com.aplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts/{accountId}")
    public AccountResponseDTO getById(@PathVariable Long accountId) {
        return new AccountResponseDTO(accountService.getAccountById(accountId));
    }

    @PostMapping("/accounts")
    public Long create(@RequestBody AccountRequestDTO accountRequestDTO) {
        return accountService.createAccount(
                accountRequestDTO.getFullName(),
                accountRequestDTO.getPhoneNumber(),
                accountRequestDTO.getEmail(),
                accountRequestDTO.getLogin(),
                accountRequestDTO.getPassword(),
                accountRequestDTO.getIsAdmin(),
                accountRequestDTO.getCity()
        );
    }

    @GetMapping("/accounts/login/{login}")
    public AccountResponseDTO getByLogin(@PathVariable String login) {
        return new AccountResponseDTO(accountService.getAccountByLogin(login));
    }

    @GetMapping("/accounts/login/{login}/password/{password}")
    public AccountResponseDTO getByLoginAndPassword(@PathVariable String login, @PathVariable String password){
        return new AccountResponseDTO(accountService.getAccountByLoginAndPassword(login, password));
    }

    @DeleteMapping("/accounts/{id}")
    public void deleteAccountById(@PathVariable("id") Long id) {
        accountService.deleteAccount(id);
    }

    public City convertCityDTOtoCity(CityRequestDTO cityDTO) {
        City city = new City();
        city.setCountry(cityDTO.getCountry());
        city.setCity(cityDTO.getCity());
        return city;
    }
}
