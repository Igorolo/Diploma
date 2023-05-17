package com.aplication.entity;


import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TestAccountKey implements Serializable {

    private Long testId;
    private Long accountId;

    public TestAccountKey() {
    }

    public TestAccountKey(Long testId, Long accountId) {
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
        if (!(o instanceof TestAccountKey)) return false;
        TestAccountKey that = (TestAccountKey) o;
        return Objects.equals(getTestId(), that.getTestId()) &&
                Objects.equals(getAccountId(), that.getAccountId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTestId(), getAccountId());
    }
}
