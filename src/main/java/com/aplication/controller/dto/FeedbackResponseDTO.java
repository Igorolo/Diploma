package com.aplication.controller.dto;

import com.aplication.entity.Feedback;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class FeedbackResponseDTO {

    @JsonProperty("feedbackId")
    private Long feedbackId;

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

    public FeedbackResponseDTO(Long feedbackId, Integer mark, Date date, String message, Long accountId, Long repairId) {
        this.feedbackId = feedbackId;
        this.mark = mark;
        this.date = date;
        this.message = message;
        this.accountId = accountId;
        this.repairId = repairId;
    }

    public FeedbackResponseDTO(Feedback feedback) {
        this.feedbackId = feedback.getId();
        this.mark = feedback.getMark();
        this.date = feedback.getDate();
        this.message = feedback.getMessage();
        this.accountId = feedback.getAccount().getAccountId();
        this.repairId = feedback.getRepair().getRepairId();
    }

    public Long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
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
