package com.aplication.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class TestAccountKeyResponseDTO {

    @JsonProperty("testId")
    private Long testId;

    @JsonProperty("accountId")
    private Long accountId;

    public TestAccountKeyResponseDTO() {
    }

    public TestAccountKeyResponseDTO(Long testId, Long accountId) {
        this.testId = testId;
        this.accountId = accountId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestAccountKeyResponseDTO)) return false;
        TestAccountKeyResponseDTO that = (TestAccountKeyResponseDTO) o;
        return Objects.equals(getTestId(), that.getTestId()) &&
                Objects.equals(getAccountId(), that.getAccountId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTestId(), getAccountId());
    }
}
