package com.aplication.controller.dto;

import com.aplication.entity.Message;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class MessageResponseDTO {

    @JsonProperty("messageId")
    private Long messageId;

    @JsonProperty("date")
    private LocalDateTime date;

    @JsonProperty("message")
    private String message;

    @JsonProperty("accountId")
    private Long accountId;

    @JsonProperty("accountFullName")
    private String accountFullName;

    public MessageResponseDTO(Long messageId, LocalDateTime date, String message, Long accountId, String accountFullName) {
        this.messageId = messageId;
        this.date = date;
        this.message = message;
        this.accountId = accountId;
        this.accountFullName = accountFullName;
    }


    public MessageResponseDTO(Message message) {
        this.messageId = message.getId();
        this.date = message.getDate();
        this.message = message.getMessage();
        this.accountId = message.getAccount().getAccountId();
        this.accountFullName = message.getAccountFullName();
    }


    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
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
