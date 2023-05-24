package com.aplication.service;
import com.aplication.entity.Account;
import com.aplication.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Autowired
    public CustomUserDetailsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String fullName) throws UsernameNotFoundException {
        Optional<Account> optionalAccount = accountRepository.findByFullName(fullName);
        Account account = optionalAccount.orElseThrow(() -> new UsernameNotFoundException("User not found"));
        // Возвращаем объект UserDetails, созданный на основе данных аккаунта
        return org.springframework.security.core.userdetails.User
                .withUsername(account.getFullName())
                .password(account.getPassword())
                .roles(account.getRoles().toArray(new String[0]))
                .build();
    }
}
