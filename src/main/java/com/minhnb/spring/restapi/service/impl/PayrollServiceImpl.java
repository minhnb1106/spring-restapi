package com.minhnb.spring.restapi.service.impl;

import com.minhnb.spring.restapi.constant.ResponseMessageKey;
import com.minhnb.spring.restapi.dto.PayrollDto;
import com.minhnb.spring.restapi.dto.StatusDto;
import com.minhnb.spring.restapi.entity.Account;
import com.minhnb.spring.restapi.entity.Payroll;
import com.minhnb.spring.restapi.exception.ApiException;
import com.minhnb.spring.restapi.repository.PayrollRepository;
import com.minhnb.spring.restapi.service.AccountService;
import com.minhnb.spring.restapi.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class PayrollServiceImpl implements PayrollService {

    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired
    private AccountService accountService;

    @Override
    public PayrollDto getPayroll(String companyCode, String username) throws ApiException {

        Account account = accountService.getAccountByCompanyCodeAndUsername(companyCode, username);

        if (account != null) {

            Optional<Payroll> payroll = payrollRepository.findByAccount(account);

            if (payroll.isPresent()) {
                return new PayrollDto(payroll.get());
            }

            throw new ApiException(new StatusDto(HttpStatus.NOT_FOUND, ResponseMessageKey.PAYROLL_NOT_FOUND));
        }

        throw new ApiException(new StatusDto(HttpStatus.UNAUTHORIZED, ResponseMessageKey.ACCOUNT_INFO_INVALID));
    }

}
