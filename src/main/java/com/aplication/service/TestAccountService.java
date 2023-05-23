package com.aplication.service;

import com.aplication.entity.Test;
import com.aplication.entity.TestAccount;
import com.aplication.entity.TestAccountKey;
import com.aplication.exceptions.TestAccountNotFoundException;
import com.aplication.exceptions.TestNotFoundException;
import com.aplication.repository.TestAccountRepository;
import com.aplication.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestAccountService {
    private final TestRepository testRepository;
    private final TestAccountRepository testAccountRepository;

    @Autowired
    public TestAccountService(TestRepository testRepository, TestAccountRepository testAccountRepository) {
        this.testRepository = testRepository;
        this.testAccountRepository = testAccountRepository;
    }

    public Integer addScore(Long testId, Long accountId, Integer score) {
        Optional<Test> testOptional = testRepository.findById(testId);
        Test test = testOptional.orElseThrow(() -> new TestNotFoundException("Unable to find test with id " + testId));

        Optional<TestAccount> testAccountOptional = testAccountRepository.findById(new TestAccountKey(testId, accountId));
        TestAccount testAccount = testAccountOptional.orElseThrow(
                () -> new TestAccountNotFoundException("Unable to find test account with id " + accountId));

        testAccount.setScore(score);
        testAccountRepository.save(testAccount);
        return score;
    }

    public Integer getScore(Long testId, Long accountId) {
        Optional<TestAccount> testAccountOptional = testAccountRepository.findById(new TestAccountKey(testId, accountId));
        TestAccount testAccount = testAccountOptional.orElseThrow(
                () -> new TestAccountNotFoundException("Unable to find test account with id " + accountId));

        return testAccount.getScore();
    }
}
