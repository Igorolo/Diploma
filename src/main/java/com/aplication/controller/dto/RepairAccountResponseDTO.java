package com.aplication.controller.dto;
import com.aplication.entity.RepairAccount;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class RepairAccountResponseDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("repairId")
    private Long repairId;

    @JsonProperty("accountId")
    private Long accountId;

    @JsonProperty("date")
    private Date date;

    @JsonProperty("repairName")
    private String repairName;

    public RepairAccountResponseDTO(Long id, Long repairId, Long accountId, Date date, String repairName) {
        this.id = id;
        this.repairId = repairId;
        this.accountId = accountId;
        this.date = date;
        this.repairName = repairName;
    }

    public RepairAccountResponseDTO(RepairAccount repairAccount) {
        this.id = repairAccount.getId();
        this.repairId = repairAccount.getRepair().getRepairId();
        this.accountId = repairAccount.getAccount().getAccountId();
        this.date = repairAccount.getDate();
        this.repairName = repairAccount.getRepairName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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