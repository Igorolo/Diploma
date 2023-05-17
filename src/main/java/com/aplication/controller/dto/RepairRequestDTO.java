package com.aplication.controller.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RepairRequestDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("address")
    private String address;

    @JsonProperty("workingSchedule")
    private String workingSchedule;

    @JsonProperty("rating")
    private Float rating;

    @JsonProperty("cityId")
    private Long cityId;

    public RepairRequestDTO(String name, String address, String workingSchedule, Float rating, Long cityId) {
        this.name = name;
        this.address = address;
        this.workingSchedule = workingSchedule;
        this.rating = rating;
        this.cityId = cityId;
    }

    public RepairRequestDTO() {
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
}
