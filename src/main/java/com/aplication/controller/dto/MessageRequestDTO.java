package com.aplication.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class MessageRequestDTO {

    @JsonProperty("date")
    private LocalDateTime date;

    @JsonProperty("message")
    private String message;

    @JsonProperty("accountId")
    private Long accountId;

    @JsonProperty("accountFullName")
    private String accountFullName;

    public MessageRequestDTO(LocalDateTime date, String message, Long accountId, String accountFullName) {
        this.date = date;
        this.message = message;
        this.accountId = accountId;
        this.accountFullName = accountFullName;
    }

    public MessageRequestDTO() {
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountFullName() {
        return accountFullName;
    }

    public void setAccountFullName(String accountFullName) {
        this.accountFullName = accountFullName;
    }
}
