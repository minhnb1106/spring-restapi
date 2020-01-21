package com.minhnb.spring.restapi.service;

import com.minhnb.spring.restapi.dto.LoginDto;
import com.minhnb.spring.restapi.entity.Account;
import com.minhnb.spring.restapi.exception.ApiException;

public interface AccountService {

    Account getAccountByCompanyCodeAndUsername(String companyCode, String username);

    String authenticateLogin(LoginDto loginDto) throws ApiException;

}
