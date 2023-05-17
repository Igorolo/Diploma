package com.aplication.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class NewsRequestDTO {

    @JsonProperty("header")
    private String header;

    @JsonProperty("text")
    private String text;

    @JsonProperty("date")
    private Date date;

    @JsonProperty("accountId")
    private Long accountId;

    public NewsRequestDTO(String header, String text, Date date, Long accountId) {
        this.header = header;
        this.text = text;
        this.date = date;
        this.accountId = accountId;
    }

    public NewsRequestDTO() {
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
