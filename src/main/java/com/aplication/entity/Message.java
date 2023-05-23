package com.aplication.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "message")
    private String message;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private Account account;

    @Column(name = "accountFullName")
    private String accountFullName;

    public Message(LocalDateTime date, String message, Account account, String accountFullName) {
        this.date = date;
        this.message = message;
        this.account = account;
        this.accountFullName = accountFullName;
    }

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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

    public String getAccountFullName() {
        return accountFullName;
    }

    public void setAccountFullName(String accountFullName) {
        this.accountFullName = accountFullName;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", date=" + date +
                ", message='" + message + '\'' +
                ", account=" + account +
                ", accountFullName='" + accountFullName + '\'' +
                '}';
    }
}
