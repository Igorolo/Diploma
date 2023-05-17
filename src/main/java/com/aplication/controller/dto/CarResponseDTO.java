package com.aplication.controller.dto;

import com.aplication.entity.Car;

public class CarResponseDTO {

    private Long carId;
    private Integer mileage;
    private String carBrand;
    private String manufacturerCountry;
    private String engine;
    private String transmission;
    private String brakeSystem;
    private String steeringWheel;
    private Long accountId;

    public CarResponseDTO(Long carId, Integer mileage, String carBrand, String manufacturerCountry, String engine,
                          String transmission, String brakeSystem, String steeringWheel, Long accountId) {
        this.carId = carId;
        this.mileage = mileage;
        this.carBrand = carBrand;
        this.manufacturerCountry = manufacturerCountry;
        this.engine = engine;
        this.transmission = transmission;
        this.brakeSystem = brakeSystem;
        this.steeringWheel = steeringWheel;
        this.accountId = accountId;
    }

    public CarResponseDTO(Car car) {
        this.carId = car.getId();
        this.mileage = car.getMileage();
        this.carBrand = car.getCarBrand();
        this.manufacturerCountry = car.getManufacturerCountry();
        this.engine = car.getEngine();
        this.transmission = car.getTransmission();
        this.brakeSystem = car.getBrakeSystem();
        this.steeringWheel = car.getSteeringWheel();
        this.accountId = car.getAccount().getAccountId();
    }


    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
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
