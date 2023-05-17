package com.aplication.controller.dto;

import com.aplication.entity.City;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AccountRequestDTO {

    @JsonProperty("fullName")
    private String fullName;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("email")
    private String email;

    @JsonProperty("login")
    private String login;

    @JsonProperty("password")
    private String password;

    @JsonProperty("isAdmin")
    private Boolean isAdmin;

    @JsonProperty("city")
    private City city;

    @JsonProperty("newsList")
    private List<NewsRequestDTO> newsList;

    @JsonProperty("messages")
    private List<MessageRequestDTO> messages;

    @JsonProperty("repairs")
    private Set<RepairRequestDTO> repairs;

    @JsonProperty("repairAccounts")
    private List<RepairAccountRequestDTO> repairAccounts;

    @JsonProperty("feedbacks")
    private List<FeedbackRequestDTO> feedbacks;

    @JsonProperty("testAccounts")
    private List<TestAccountRequestDTO> testAccounts;

    @JsonProperty("car")
    private CarRequestDTO car;





    // Геттеры и сеттеры

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public List<NewsRequestDTO> getNewsList() {
        return newsList;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public void setNewsList(List<NewsRequestDTO> newsList) {
        this.newsList = newsList;
    }

    public List<MessageRequestDTO> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageRequestDTO> messages) {
        this.messages = messages;
    }

    public Set<RepairRequestDTO> getRepairs() {
        return repairs;
    }

    public void setRepairs(Set<RepairRequestDTO> repairs) {
        this.repairs = repairs;
    }

    public List<RepairAccountRequestDTO> getRepairAccounts() {
        return repairAccounts;
    }

    public void setRepairAccounts(List<RepairAccountRequestDTO> repairAccounts) {
        this.repairAccounts = repairAccounts;
    }

    public List<FeedbackRequestDTO> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<FeedbackRequestDTO> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public List<TestAccountRequestDTO> getTestAccounts() {
        return testAccounts;
    }

    public void setTestAccounts(List<TestAccountRequestDTO> testAccounts) {
        this.testAccounts = testAccounts;
    }

    public CarRequestDTO getCar() {
        return car;
    }

    public void setCar(CarRequestDTO car) {
        this.car = car;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}