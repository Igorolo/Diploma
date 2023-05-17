package com.aplication.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestRequestDTO {

    @JsonProperty("question")
    private String question;

    @JsonProperty("answer")
    private String answer;

    public TestRequestDTO(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public TestRequestDTO() {
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
}
