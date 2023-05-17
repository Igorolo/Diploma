package com.aplication.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class FeedbackRequestDTO {

    @JsonProperty("mark")
    private Integer mark;

    @JsonProperty("date")
    private Date date;

    @JsonProperty("message")
    private String message;

    @JsonProperty("accountId")
    private Long accountId;

    @JsonProperty("repairId")
    private Long repairId;

    public FeedbackRequestDTO(Integer mark, Date date, String message, Long accountId, Long repairId) {
        this.mark = mark;
        this.date = date;
        this.message = message;
        this.accountId = accountId;
        this.repairId = repairId;
    }

    public FeedbackRequestDTO() {
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public Long getRepairId() {
        return repairId;
    }

    public void setRepairId(Long repairId) {
        this.repairId = repairId;
    }
}
