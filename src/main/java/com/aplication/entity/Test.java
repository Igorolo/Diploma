package com.aplication.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "test")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "question")
    private String question;

    @Column(name = "answer")
    private String answer;

    @OneToMany(mappedBy = "test")
    private Set<TestAccount> testAccounts = new HashSet<>();

    public Test(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }



    public Test() {
    }

    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Set<TestAccount> getTestAccounts() {
        return testAccounts;
    }

    public void setTestAccounts(Set<TestAccount> testAccounts) {
        this.testAccounts = testAccounts;
    }

    public void addTestAccount(TestAccount testAccount) {
        testAccounts.add(testAccount);
        testAccount.setTest(this);
    }

    public void removeTestAccount(TestAccount testAccount) {
        testAccounts.remove(testAccount);
        testAccount.setTest(null);
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", testAccounts=" + testAccounts +
                '}';
    }
}
