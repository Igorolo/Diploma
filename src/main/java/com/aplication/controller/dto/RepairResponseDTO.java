package com.aplication.controller.dto;

import com.aplication.entity.Account;
import com.aplication.entity.Feedback;
import com.aplication.entity.Repair;

import java.util.ArrayList;
import java.util.List;

public class RepairResponseDTO {

    private Long repairId;
    private String name;
    private String address;
    private String workingSchedule;
    private Float rating;
    private Long cityId;
    private List<Account> accounts;
    private List<Feedback> feedbacks;

    public RepairResponseDTO(Long repairId, String name, String address, String workingSchedule, Float rating, Long cityId, List<Account> accounts, List<Feedback> feedbacks) {
        this.repairId = repairId;
        this.name = name;
        this.address = address;
        this.workingSchedule = workingSchedule;
        this.rating = rating;
        this.cityId = cityId;
        this.accounts = accounts;
        this.feedbacks = feedbacks;
    }

    public RepairResponseDTO(Repair repair) {
        this.repairId = repair.getRepairId();
        this.name = repair.getName();
        this.address = repair.getAddress();
        this.workingSchedule = repair.getWorkingSchedule();
        this.rating = repair.getRating();
        this.cityId = repair.getCity().getId();
        this.accounts = repair.getAccounts();
        this.feedbacks = repair.getFeedbacks();
    }

    public RepairResponseDTO() {
    }

    public Long getRepairId() {
        return repairId;
    }

    public void setRepairId(Long repairId) {
        this.repairId = repairId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkingSchedule() {
        return workingSchedule;
    }

    public void setWorkingSchedule(String workingSchedule) {
        this.workingSchedule = workingSchedule;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public static List<RepairResponseDTO> fromList(List<Repair> repairs) {
        List<RepairResponseDTO> responseDTOs = new ArrayList<>();
        for (Repair repair : repairs) {
            RepairResponseDTO responseDTO = new RepairResponseDTO();
            responseDTO.setRepairId(repair.getRepairId());
            responseDTO.setName(repair.getName());
            responseDTO.setAddress(repair.getAddress());
            responseDTO.setWorkingSchedule(repair.getWorkingSchedule());
            responseDTO.setRating(repair.getRating());
            responseDTOs.add(responseDTO);
        }
        return responseDTOs;
    }
}

