package com.minhnb.spring.restapi.service.impl;

import com.minhnb.spring.restapi.constant.ResponseMessageKey;
import com.minhnb.spring.restapi.dto.LoginDto;
import com.minhnb.spring.restapi.dto.StatusDto;
import com.minhnb.spring.restapi.entity.Account;
import com.minhnb.spring.restapi.exception.ApiException;
import com.minhnb.spring.restapi.repository.AccountRepository;
import com.minhnb.spring.restapi.service.AccountService;
import com.minhnb.spring.restapi.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Transactional
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${jwt.claims-key.company-code}")
    private String keyCompanyCode;

    @Override
    public Account getAccountByCompanyCodeAndUsername(String companyCode, String username) {

        return accountRepository.findByCompanyCodeAndUserName(companyCode, username).orElse(null);
    }

    @Override
    public String authenticateLogin(LoginDto loginDto) throws ApiException {

        Account account = getAccountByCompanyCodeAndUsername(loginDto.getCompanyCode(), loginDto.getUsername());

        if (account != null && passwordEncoder.matches(loginDto.getPassword(), account.getPassword())) {

            Map<String, Object> claims = new HashMap<>();
            claims.put(keyCompanyCode, account.getCompanyCode());

            return jwtUtil.createToken(claims, account.getUserName());
        }

        throw new ApiException(new StatusDto(HttpStatus.UNAUTHORIZED, ResponseMessageKey.ACCOUNT_INFO_INVALID));
    }

}
