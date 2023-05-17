package com.aplication.controller;

import com.aplication.service.TestAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestAccountController {
    private final TestAccountService testAccountService;

    @Autowired
    public TestAccountController(TestAccountService testAccountService) {
        this.testAccountService = testAccountService;
    }

    @PostMapping("/tests/{testId}/accounts/{accountId}/score")
    public void addScore(@PathVariable Long testId, @PathVariable Long accountId, @RequestParam Integer score) {
        testAccountService.addScore(testId, accountId, score);
    }

    @GetMapping("/tests/{testId}/accounts/{accountId}/score")
    public Integer getScore(@PathVariable Long testId, @PathVariable Long accountId) {
        return testAccountService.getScore(testId, accountId);
    }
}
