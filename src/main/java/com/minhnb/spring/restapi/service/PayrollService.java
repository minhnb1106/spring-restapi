package com.minhnb.spring.restapi.service;

import com.minhnb.spring.restapi.dto.PayrollDto;
import com.minhnb.spring.restapi.exception.ApiException;
import org.springframework.web.bind.annotation.RequestParam;

public interface PayrollService {

    PayrollDto getPayroll(String companyCode, @RequestParam String username) throws ApiException;

}
