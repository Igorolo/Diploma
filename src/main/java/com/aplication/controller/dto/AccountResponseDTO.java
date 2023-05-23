package com.aplication.controller.dto;

import com.aplication.entity.Account;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AccountResponseDTO {

    private Long accountId;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String login;
    private String password;
    private Boolean isAdmin;
    private CityResponseDTO city;
    private List<NewsResponseDTO> newsList;
    private List<MessageResponseDTO> messages;
    private Set<RepairResponseDTO> repairs;
    private List<RepairAccountResponseDTO> repairAccounts;
    private List<FeedbackResponseDTO> feedbacks;
    private List<TestAccountResponseDTO> testAccounts;
    private CarResponseDTO car;

    public AccountResponseDTO(Long accountId, String fullName, String phoneNumber, String email, String login, String password, Boolean isAdmin, CityResponseDTO city, List<NewsResponseDTO> newsList, List<MessageResponseDTO> messages, Set<RepairResponseDTO> repairs, List<RepairAccountResponseDTO> repairAccounts, List<FeedbackResponseDTO> feedbacks, List<TestAccountResponseDTO> testAccounts, CarResponseDTO car) {
        this.accountId = accountId;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
        this.city = city;
        this.newsList = newsList;
        this.messages = messages;
        this.repairs = repairs;
        this.repairAccounts = repairAccounts;
        this.feedbacks = feedbacks;
        this.testAccounts = testAccounts;
        this.car = car;
    }

    public AccountResponseDTO(Account account) {
        this.accountId = account.getAccountId();
        this.fullName = account.getFullName();
        this.phoneNumber = account.getPhoneNumber();
        this.email = account.getEmail();
        this.login = account.getLogin();
        this.password = account.getPassword();
        this.isAdmin = account.getAdmin();
        this.city = new CityResponseDTO(account.getCity());
        this.newsList = account.getNewsList().stream()
                .map(NewsResponseDTO::new)
                .collect(Collectors.toList());
        this.messages = account.getMessages().stream()
                .map(MessageResponseDTO::new)
                .collect(Collectors.toList());
        this.repairs = account.getRepairs().stream()
                .map(RepairResponseDTO::new)
                .collect(Collectors.toSet());
        this.repairAccounts = account.getRepairAccounts().stream()
                .map(RepairAccountResponseDTO::new)
                .collect(Collectors.toList());
        this.feedbacks = account.getFeedbacks().stream()
                .map(FeedbackResponseDTO::new)
                .collect(Collectors.toList());
        this.testAccounts = account.getTestAccounts().stream()
                .map(TestAccountResponseDTO::new)
                .collect(Collectors.toList());
        if (account.getCar() != null) {
            this.car = new CarResponseDTO(account.getCar());
        } else {
            this.car = null; // Если поле car равно null, присвоить null в AccountResponseDTO
        }
    }
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

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

    public CityResponseDTO getCity() {
        return city;
    }

    public void setCity(CityResponseDTO city) {
        this.city = city;
    }

    public List<NewsResponseDTO> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<NewsResponseDTO> newsList) {
        this.newsList = newsList;
    }

    public List<MessageResponseDTO> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageResponseDTO> messages) {
        this.messages = messages;
    }

    public Set<RepairResponseDTO> getRepairs() {
        return repairs;
    }

    public void setRepairs(Set<RepairResponseDTO> repairs) {
        this.repairs = repairs;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public List<RepairAccountResponseDTO> getRepairAccounts() {
        return repairAccounts;
    }

    public void setRepairAccounts(List<RepairAccountResponseDTO> repairAccounts) {
        this.repairAccounts = repairAccounts;
    }

    public List<FeedbackResponseDTO> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<FeedbackResponseDTO> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public List<TestAccountResponseDTO> getTestAccounts() {
        return testAccounts;
    }

    public void setTestAccounts(List<TestAccountResponseDTO> testAccounts) {
        this.testAccounts = testAccounts;
    }

    public CarResponseDTO getCar() {
        return car;
    }

    public void setCar(CarResponseDTO car) {
        this.car = car;
    }
}


