package com.aplication.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestAccountRequestDTO {

    @JsonProperty("testId")
    private Long testId;

    @JsonProperty("accountId")
    private Long accountId;

    @JsonProperty("score")
    private Integer score;

    public TestAccountRequestDTO(Long testId, Long accountId, Integer score) {
        this.testId = testId;
        this.accountId = accountId;
        this.score = score;
    }

    public TestAccountRequestDTO() {
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

    @Override
    public String toString() {
        return "TestAccountRequestDTO{" +
                "testId=" + testId +
                ", accountId=" + accountId +
                ", score=" + score +
                '}';
    }
}
