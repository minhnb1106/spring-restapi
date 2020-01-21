package com.minhnb.spring.restapi.controller;

import com.minhnb.spring.restapi.constant.ResponseMessageKey;
import com.minhnb.spring.restapi.dto.PayrollDto;
import com.minhnb.spring.restapi.dto.ResponseDto;
import com.minhnb.spring.restapi.dto.StatusDto;
import com.minhnb.spring.restapi.exception.ApiException;
import com.minhnb.spring.restapi.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    @GetMapping("/payroll")
    public ResponseDto<PayrollDto> getPayroll(@RequestParam String companyCode, @RequestParam String username) throws ApiException {

        PayrollDto payrollDto = payrollService.getPayroll(companyCode, username);

        return new ResponseDto<>(payrollDto, new StatusDto(HttpStatus.OK, ResponseMessageKey.SUCCESS));
    }

}
