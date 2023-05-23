package com.aplication.controller;

import com.aplication.controller.dto.TestAccountRequestDTO;
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
    public Integer addScore(@RequestBody TestAccountRequestDTO testAccountRequestDTO) {
        testAccountService.addScore(testAccountRequestDTO.getTestId(), testAccountRequestDTO.getAccountId(),
                testAccountRequestDTO.getScore());
        return testAccountRequestDTO.getScore();
    }

    @GetMapping("/tests/{testId}/accounts/{accountId}/score")
    public Integer getScore(@PathVariable Long testId, @PathVariable Long accountId) {
        return testAccountService.getScore(testId, accountId);
    }
}
