package com.aplication.service;

import com.aplication.entity.Account;
import com.aplication.entity.Message;
import com.aplication.exceptions.AccountNotFoundException;
import com.aplication.exceptions.MessageNotFoundException;
import com.aplication.repository.AccountRepository;
import com.aplication.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository, AccountRepository accountRepository) {
        this.messageRepository = messageRepository;
        this.accountRepository = accountRepository;
    }

    public Long save(LocalDateTime date, String message, Long accountId, String accountFullName) {
        // Получение аккаунта по идентификатору
        Optional<Account> accountOptional = accountRepository.findById(accountId);
        Account account = accountOptional.orElseThrow(() -> new AccountNotFoundException("Не удалось найти аккаунт с идентификатором " + accountId));

        Message messageEntity = new Message(date, message, account, accountFullName);
        Message savedMessage = messageRepository.save(messageEntity);
        return savedMessage.getId();
    }

    public Message getById(Long messageId) {
        return messageRepository.findById(messageId)
                .orElseThrow(() -> new MessageNotFoundException("Не удалось найти сообщение с идентификатором " + messageId));
    }

    public void deleteById(Long messageId) {
        messageRepository.deleteById(messageId);
    }
}
