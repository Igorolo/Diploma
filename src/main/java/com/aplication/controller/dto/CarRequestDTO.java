package com.aplication.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarRequestDTO {
    @JsonProperty("mileage")
    private Integer mileage;

    @JsonProperty("carBrand")
    private String carBrand;

    @JsonProperty("manufacturerCountry")
    private String manufacturerCountry;

    @JsonProperty("engine")
    private String engine;

    @JsonProperty("transmission")
    private String transmission;

    @JsonProperty("brakeSystem")
    private String brakeSystem;

    @JsonProperty("steeringWheel")
    private String steeringWheel;

    @JsonProperty("accountId")
    private Long accountId;

    public CarRequestDTO(Integer mileage, String carBrand, String manufacturerCountry, String engine,
                         String transmission, String brakeSystem, String steeringWheel, Long accountId) {
        this.mileage = mileage;
        this.carBrand = carBrand;
        this.manufacturerCountry = manufacturerCountry;
        this.engine = engine;
        this.transmission = transmission;
        this.brakeSystem = brakeSystem;
        this.steeringWheel = steeringWheel;
        this.accountId = accountId;
    }

    public CarRequestDTO() {
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getManufacturerCountry() {
        return manufacturerCountry;
    }

    public void setManufacturerCountry(String manufacturerCountry) {
        this.manufacturerCountry = manufacturerCountry;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getBrakeSystem() {
        return brakeSystem;
    }

    public void setBrakeSystem(String brakeSystem) {
        this.brakeSystem = brakeSystem;
    }

    public String getSteeringWheel() {
        return steeringWheel;
    }

    public void setSteeringWheel(String steeringWheel) {
        this.steeringWheel = steeringWheel;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
