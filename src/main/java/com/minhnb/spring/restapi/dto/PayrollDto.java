package com.minhnb.spring.restapi.dto;

import com.minhnb.spring.restapi.entity.Payroll;

public class PayrollDto {

    private String username;
    private String year;
    private String month;
    private int salary = 0;

    public PayrollDto() {
    }

    public PayrollDto(String username, String year, String month, int salary) {
        this.username = username;
        this.year = year;
        this.month = month;
        this.salary = salary;
    }

    public PayrollDto(Payroll payroll) {
        this.username = payroll.getAccount().getUserName();
        this.year = payroll.getYear();
        this.month = payroll.getMonth();
        this.salary = payroll.getSalary();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

