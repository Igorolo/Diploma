package com.aplication.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "repair_account")
public class RepairAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "repair_id")
    private Repair repair;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "date")
    private Date date;

    @Column(name = "repair_name")
    private String repairName;

    public RepairAccount(Repair repair, Account account, Date date, String repairName) {
        this.repair = repair;
        this.account = account;
        this.date = date;
        this.repairName = repairName;
    }

    public RepairAccount() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRepairName() {
        return repairName;
    }

    public void setRepairName(String repairName) {
        this.repairName = repairName;
    }

    @Override
    public String toString() {
        return "RepairAccount{" +
                "id=" + id +
                ", repair=" + repair +
                ", account=" + account +
                ", date=" + date +
                ", repairName='" + repairName + '\'' +
                '}';
    }
}
