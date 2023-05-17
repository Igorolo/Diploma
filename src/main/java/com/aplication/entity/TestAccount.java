package com.aplication.entity;

import javax.persistence.*;

@Entity
@Table(name = "test_account")
public class TestAccount {

    @EmbeddedId
    private TestAccountKey id = new TestAccountKey();

    @ManyToOne
    @MapsId("testId")
    private Test test;

    @ManyToOne
    @MapsId("accountId")
    private Account account;

    @Column(name = "score")
    private Integer score;

    public TestAccount(Test test, Account account, Integer score) {
        this.test = test;
        this.account = account;
        this.score = score;
    }

    public TestAccount() {
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "TestAccount{" +
                "id=" + id +
                ", test=" + test +
                ", account=" + account +
                ", score=" + score +
                '}';
    }
}
