package com.aplication.entity;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "mileage")
    private Integer mileage;

    @Column(name = "car_brand")
    private String carBrand;

    @Column(name = "manufacturer_country")
    private String manufacturerCountry;

    @Column(name = "engine")
    private String engine;

    @Column(name = "transmission")
    private String transmission;

    @Column(name = "brake_system")
    private String brakeSystem;

    @Column(name = "steering_wheel")
    private String steeringWheel;

    @OneToOne
    @JoinColumn(name = "account_id", unique = true)
    private Account account;

    public Car(Integer mileage, String carBrand, String manufacturerCountry, String engine, String transmission,
               String brakeSystem, String steeringWheel, Account account) {
        this.mileage = mileage;
        this.carBrand = carBrand;
        this.manufacturerCountry = manufacturerCountry;
        this.engine = engine;
        this.transmission = transmission;
        this.brakeSystem = brakeSystem;
        this.steeringWheel = steeringWheel;
        this.account = account;
    }

    public Car() {
    }

    public Long getId() {
        return id;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mileage=" + mileage +
                ", carBrand='" + carBrand + '\'' +
                ", manufacturerCountry='" + manufacturerCountry + '\'' +
                ", engine='" + engine + '\'' +
                ", transmission='" + transmission + '\'' +
                ", brakeSystem='" + brakeSystem + '\'' +
                ", steeringWheel='" + steeringWheel + '\'' +
                ", account=" + account +
                '}';
    }
}