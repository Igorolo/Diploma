package com.aplication.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class RepairAccountRequestDTO {

    @JsonProperty("repairId")
    private Long repairId;

    @JsonProperty("accountId")
    private Long accountId;

    @JsonProperty("date")
    private Date date;

    @JsonProperty("repairName")
    private String repairName;

    public RepairAccountRequestDTO(Long repairId, Long accountId, Date date, String repairName) {
        this.repairId = repairId;
        this.accountId = accountId;
        this.date = date;
        this.repairName = repairName;
    }

    public RepairAccountRequestDTO() {
    }

    public Long getRepairId() {
        return repairId;
    }

    public void setRepairId(Long repairId) {
        this.repairId = repairId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRepairName() {
        return repairName;
    }

    public void setRepairName(String repairName) {
        this.repairName = repairName;
    }
}
