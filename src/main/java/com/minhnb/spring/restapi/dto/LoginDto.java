package com.minhnb.spring.restapi.dto;

import com.minhnb.spring.restapi.constant.Role;

public class LoginDto {

    private String companyCode;
    private String username;
    private String password;
    private Role role;

    public LoginDto() {
    }

    public LoginDto(String companyCode, String username, String password) {
        this.companyCode = companyCode;
        this.username = username;
        this.password = password;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

}
