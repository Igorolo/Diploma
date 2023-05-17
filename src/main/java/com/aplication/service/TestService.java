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
public class TestService {
    private final TestRepository testRepository;
    private final TestAccountRepository testAccountRepository;

    @Autowired
    public TestService(TestRepository testRepository, TestAccountRepository testAccountRepository) {
        this.testRepository = testRepository;
        this.testAccountRepository = testAccountRepository;
    }

    public Long createTest(String question, String answer) {
        Test test = new Test(question, answer);
        Test savedTest = testRepository.save(test);
        return savedTest.getId();
    }

    public Test getById(Long testId) {
        return testRepository.findById(testId)
                .orElseThrow(() -> new TestNotFoundException("Unable to find test with id " + testId));
    }

    public void updateTest(Long testId, String question, String answer) {
        Optional<Test> testOptional = testRepository.findById(testId);
        Test test = testOptional.orElseThrow(() -> new TestNotFoundException("Unable to find test with id " + testId));

        test.setQuestion(question);
        test.setAnswer(answer);
        testRepository.save(test);
    }

    public void deleteById(Long testId) {
        testRepository.deleteById(testId);
    }

    public void addTestAccount(Long testId, Long accountId) {
        Optional<Test> testOptional = testRepository.findById(testId);
        Test test = testOptional.orElseThrow(() -> new TestNotFoundException("Unable to find test with id " + testId));

        Optional<TestAccount> testAccountOptional = testAccountRepository.findById(new TestAccountKey(testId, accountId));
        TestAccount testAccount = testAccountOptional.orElseThrow(() -> new TestAccountNotFoundException("Unable to find test account with id " + accountId));

        test.addTestAccount(testAccount);
        testRepository.save(test);
    }

    public void removeTestAccount(Long testId, Long accountId) {
        Optional<Test> testOptional = testRepository.findById(testId);
        Test test = testOptional.orElseThrow(() -> new TestNotFoundException("Unable to find test with id " + testId));

        Optional<TestAccount> testAccountOptional = testAccountRepository.findById(new TestAccountKey(testId, accountId));
        TestAccount testAccount = testAccountOptional.orElseThrow(() -> new TestAccountNotFoundException("Unable to find test account with id " + accountId));

        test.removeTestAccount(testAccount);
        testRepository.save(test);
    }
}

