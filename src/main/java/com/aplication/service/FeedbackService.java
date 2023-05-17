package com.aplication.service;

import com.aplication.entity.Account;
import com.aplication.entity.Feedback;
import com.aplication.entity.Repair;
import com.aplication.exceptions.AccountNotFoundException;
import com.aplication.exceptions.FeedbackNotFoundException;
import com.aplication.exceptions.RepairNotFoundException;
import com.aplication.repository.AccountRepository;
import com.aplication.repository.FeedbackRepository;
import com.aplication.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final AccountRepository accountRepository;
    private final RepairRepository repairRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository, AccountRepository accountRepository, RepairRepository repairRepository) {
        this.feedbackRepository = feedbackRepository;
        this.accountRepository = accountRepository;
        this.repairRepository = repairRepository;
    }
    public Long save(Integer mark, String message, Long accountId, Long repairId) {
        // Получение аккаунта по идентификатору
        Optional<Account> accountOptional = accountRepository.findById(accountId);
        Account account = accountOptional.orElseThrow(() -> new AccountNotFoundException("Unable to find account with id " + accountId));

        // Получение ремонта по идентификатору
        Optional<Repair> repairOptional = repairRepository.findById(repairId);
        Repair repair = repairOptional.orElseThrow(() -> new RepairNotFoundException("Unable to find repair with id " + repairId));

        Feedback feedback = new Feedback(mark, new Date(), message, account, repair);
        Feedback savedFeedback = feedbackRepository.save(feedback);
        return savedFeedback.getId();
    }

    public Feedback getById(Long feedbackId) {
        return feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new FeedbackNotFoundException("Unable to find feedback with id " + feedbackId));
    }

    public void deleteById(Long feedbackId) {
        feedbackRepository.deleteById(feedbackId);
    }
}


