package com.aplication.controller.dto;

import com.aplication.entity.News;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class NewsResponseDTO {

    @JsonProperty("newsId")
    private Long newsId;

    @JsonProperty("header")
    private String header;

    @JsonProperty("text")
    private String text;

    @JsonProperty("date")
    private Date date;

    @JsonProperty("accountId")
    private Long accountId;

    public NewsResponseDTO(Long newsId, String header, String text, Date date, Long accountId) {
        this.newsId = newsId;
        this.header = header;
        this.text = text;
        this.date = date;
        this.accountId = accountId;
    }

    public NewsResponseDTO(News news) {
        this.newsId = news.getNewsId();
        this.header = news.getHeader();
        this.text = news.getText();
        this.date = news.getDate();
        this.accountId = news.getAccount().getAccountId();
    }

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
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
