package com.aplication.controller;

import com.aplication.controller.dto.TestRequestDTO;
import com.aplication.controller.dto.TestResponseDTO;
import com.aplication.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping("/tests")
    public Long createTest(@RequestBody TestRequestDTO testRequestDTO) {
        return testService.createTest(testRequestDTO.getQuestion(), testRequestDTO.getAnswer());
    }

    @GetMapping("/tests/{testId}")
    public TestResponseDTO getTestById(@PathVariable Long testId) {
        return new TestResponseDTO(testService.getById(testId));
    }

    @PutMapping("/tests/{testId}")
    public void updateTest(@PathVariable Long testId, @RequestBody TestRequestDTO testRequestDTO) {
        testService.updateTest(testId, testRequestDTO.getQuestion(), testRequestDTO.getAnswer());
    }

    @DeleteMapping("/tests/{testId}")
    public void deleteTestById(@PathVariable Long testId) {
        testService.deleteById(testId);
    }

    @PostMapping("/tests/{testId}/accounts/{accountId}")
    public void addTestAccount(@PathVariable Long testId, @PathVariable Long accountId) {
        testService.addTestAccount(testId, accountId);
    }

    @DeleteMapping("/tests/{testId}/accounts/{accountId}")
    public void removeTestAccount(@PathVariable Long testId, @PathVariable Long accountId) {
        testService.removeTestAccount(testId, accountId);
    }
}