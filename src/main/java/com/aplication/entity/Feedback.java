package com.aplication.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "mark")
    private Integer mark;

    @Column(name = "date")
    private Date date;

    @Column(name = "message")
    private String message;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "repair_id", referencedColumnName = "repair_id")
    private Repair repair;

    public Feedback(Integer mark, Date date, String message, Account account, Repair repair) {
        this.mark = mark;
        this.date = date;
        this.message = message;
        this.account = account;
        this.repair = repair;
    }

    public Feedback() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", mark=" + mark +
                ", date=" + date +
                ", message='" + message + '\'' +
                ", account=" + account +
                ", repair=" + repair +
                '}';
    }
}
