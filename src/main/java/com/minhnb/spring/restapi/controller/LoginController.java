package com.minhnb.spring.restapi.controller;

import com.minhnb.spring.restapi.constant.ResponseMessageKey;
import com.minhnb.spring.restapi.dto.LoginDto;
import com.minhnb.spring.restapi.dto.ResponseDto;
import com.minhnb.spring.restapi.dto.StatusDto;
import com.minhnb.spring.restapi.exception.ApiException;
import com.minhnb.spring.restapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class LoginController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    public ResponseDto<String> login(@RequestBody LoginDto loginDto) throws ApiException {

        String authToken = accountService.authenticateLogin(loginDto);

        return new ResponseDto<String>(authToken, new StatusDto(HttpStatus.OK, ResponseMessageKey.SUCCESS));
    }

}
