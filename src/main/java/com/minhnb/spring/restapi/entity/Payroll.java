package com.minhnb.spring.restapi.entity;

import com.minhnb.spring.restapi.base.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Access(AccessType.FIELD)
@Entity
@Table(name = "payroll")
public class Payroll extends BaseEntity {

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @NotNull
    @Size(max = 4)
    @Column(name = "year")
    private String year;

    @NotNull
    @Size(max = 2)
    @Column(name = "month")
    private String month;

    @NotNull
    @Column(name = "salary")
    private int salary = 0;

    public Payroll() {
    }

    public Payroll(Account account, String year, String month, int salary) {
        this.account = account;
        this.year = year;
        this.month = month;
        this.salary = salary;
        this.account.setPayroll(this);
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
