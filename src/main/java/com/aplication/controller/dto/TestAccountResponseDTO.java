package com.aplication.controller.dto;

import com.aplication.entity.TestAccount;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TestAccountResponseDTO {
    @JsonProperty("testId")
    private Long testId;

    @JsonProperty("accountId")
    private Long accountId;

    @JsonProperty("score")
    private Integer score;

    public TestAccountResponseDTO(Long testId, Long accountId, Integer score) {
        this.testId = testId;
        this.accountId = accountId;
        this.score = score;
    }

    public TestAccountResponseDTO(TestAccount testAccount) {
        this.testId = testAccount.getTest().getId();
        this.accountId = testAccount.getAccount().getAccountId();
        this.score = testAccount.getScore();
    }

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
