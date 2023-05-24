package com.aplication.entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "fullName", nullable = false)
    private String fullName;

    @Column(name = "phoneNumber", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "password")
    private String password;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "account_role", joinColumns = @JoinColumn(name = "account_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;


    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<News> newsList;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "account_repair",
            joinColumns = { @JoinColumn(name = "account_id") },
            inverseJoinColumns = { @JoinColumn(name = "repair_id") }
    )
    private Set<Repair> repairs = new HashSet<>();

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RepairAccount> repairAccounts = new ArrayList<>();

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Feedback> feedbacks = new ArrayList<>();

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TestAccount> testAccounts = new ArrayList<>();

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id", nullable = true)
    private Car car;


    public Account(String fullName, String phoneNumber, String email, String login,
                   String password, City city) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.login = login;
        this.password = password;
        this.city = city;
        this.newsList = new ArrayList<>();
        this.messages = new ArrayList<>();
        this.repairs = new HashSet<>();
        this.repairAccounts = new ArrayList<>();
        this.feedbacks = new ArrayList<>();
        this.testAccounts = new ArrayList<>();
        this.roles = new HashSet<>();
    }

    public Account() {
        this.newsList = new ArrayList<>();
        this.messages = new ArrayList<>();
        this.repairs = new HashSet<>();
        this.repairAccounts = new ArrayList<>();
        this.feedbacks = new ArrayList<>();
        this.testAccounts = new ArrayList<>();
        this.roles = new HashSet<>();
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public Set<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(Set<Repair> repairs) {
        this.repairs = repairs;
    }

    public void addRepair(Repair repair) {
        repairs.add(repair);
        repair.getAccounts().add(this);
    }

    public void removeRepair(Repair repair) {
        repairs.remove(repair);
        repair.getAccounts().remove(this);
    }

    public List<RepairAccount> getRepairAccounts() {
        return repairAccounts;
    }

    public void setRepairAccounts(List<RepairAccount> repairAccounts) {
        this.repairAccounts = repairAccounts;
    }

    public void addRepairAccount(RepairAccount repairAccount) {
        repairAccounts.add(repairAccount);
        repairAccount.setAccount(this);
    }

    public void removeRepairAccount(RepairAccount repairAccount) {
        repairAccounts.remove(repairAccount);
        repairAccount.setAccount(null);
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


    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public void addNews(News news) {
        newsList.add(news);
        news.setAccount(this);
    }

    public void removeNews(News news) {
        newsList.remove(news);
        news.setAccount(null);
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void addMessage(Message message) {
        messages.add(message);
        message.setAccount(this);
    }

    public void removeMessage(Message message) {
        messages.remove(message);
        message.setAccount(null);
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public void addFeedback(Feedback feedback) {
        feedbacks.add(feedback);
        feedback.setAccount(this);
    }

    public void removeFeedback(Feedback feedback) {
        feedbacks.remove(feedback);
        feedback.setAccount(null);
    }


    public List<TestAccount> getTestAccounts() {
        return testAccounts;
    }

    public void setTestAccounts(List<TestAccount> testAccounts) {
        this.testAccounts = testAccounts;
    }

    public void addTestAccount(TestAccount testAccount) {
        testAccounts.add(testAccount);
        testAccount.setAccount(this);
    }

    public void removeTestAccount(TestAccount testAccount) {
        testAccounts.remove(testAccount);
        testAccount.setAccount(null);
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", city=" + city +
                ", newsList=" + newsList +
                ", messages=" + messages +
                ", repairs=" + repairs +
                ", repairAccounts=" + repairAccounts +
                ", feedbacks=" + feedbacks +
                ", testAccounts=" + testAccounts +
                ", car=" + car +
                '}';
    }
}
