package com.aplication.entity;

import com.aplication.entity.Account;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "repair")
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "repair_id")
    private Long repairId;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "working_schedule")
    private String workingSchedule;

    @Column(name = "rating")
    private Float rating;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToMany
    @JoinTable(
            name = "account_repair",
            joinColumns = @JoinColumn(name = "repair_id"),
            inverseJoinColumns = @JoinColumn(name = "account_id")
    )
    private List<Account> accounts;

    @OneToMany(mappedBy = "repair", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Feedback> feedbacks;

    public Repair(String name, String address, String workingSchedule, Float rating, City city) {
        this.name = name;
        this.address = address;
        this.workingSchedule = workingSchedule;
        this.rating = rating;
        this.city = city;
        this.accounts = new ArrayList<>();
        this.feedbacks = new ArrayList<>();
    }

    public Repair() {
        this.accounts = new ArrayList<>();
        this.feedbacks = new ArrayList<>();
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
        account.getRepairs().add(this);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
        account.getRepairs().remove(this);
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public void addFeedback(Feedback feedback) {
        feedbacks.add(feedback);
        feedback.setRepair(this);
    }

    public void removeFeedback(Feedback feedback) {
        feedbacks.remove(feedback);
        feedback.setRepair(null);
    }

    @Override
    public String toString() {
        return "Repair{" +
                "repairId=" + repairId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", workingSchedule='" + workingSchedule + '\'' +
                ", rating=" + rating +
                ", city=" + city +
                ", accounts=" + accounts +
                ", feedbacks=" + feedbacks +
                '}';
    }
}
