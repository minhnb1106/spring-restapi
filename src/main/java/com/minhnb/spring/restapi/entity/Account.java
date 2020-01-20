package com.minhnb.spring.restapi.entity;

import com.minhnb.spring.restapi.base.BaseEntity;
import com.minhnb.spring.restapi.constant.Role;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Access(AccessType.FIELD)
@Entity
@Table(name = "account", uniqueConstraints = @UniqueConstraint(columnNames = {"user_name"}))
public class Account extends BaseEntity {

    @NotNull
    @Size(max = 10)
    @Column(name = "houjin_code")
    private String houjinCode;

    @NotNull
    @Size(max = 20)
    @Column(name = "user_name")
    private String userName;

    @NotNull
    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Size(max = 10)
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "account")
    private Payroll payroll;

    public Account() {
    }

    public Account(String houjinCode, String userName, String password, Role role) {
        this.houjinCode = houjinCode;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public String getHoujinCode() {
        return houjinCode;
    }

    public void setHoujinCode(String houjinCode) {
        this.houjinCode = houjinCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Payroll getPayroll() {
        return payroll;
    }

    public void setPayroll(Payroll payroll) {
        this.payroll = payroll;
    }

}
