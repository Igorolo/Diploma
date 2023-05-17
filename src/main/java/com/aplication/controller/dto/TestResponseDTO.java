package com.aplication.controller.dto;

import com.aplication.entity.Test;
import com.aplication.entity.TestAccount;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class TestResponseDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("question")
    private String question;

    @JsonProperty("answer")
    private String answer;

    @JsonProperty("testAccounts")
    private Set<TestAccount> testAccounts;

    public TestResponseDTO(Long id, String question, String answer, Set<TestAccount> testAccounts) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.testAccounts = testAccounts;
    }

    public TestResponseDTO(Test test) {
        this.id = test.getId();
        this.question = test.getQuestion();
        this.answer = test.getAnswer();
        this.testAccounts = test.getTestAccounts();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
