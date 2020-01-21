package com.minhnb.spring.restapi.constant;

public enum ResponseMessageKey {

    SUCCESS("success"),
    FAILURE("failure"),
    ACCOUNT_INFO_INVALID("failure_account_info_invalid"),
    PAYROLL_NOT_FOUND("failure_payroll_not_found");

    private String message;

    ResponseMessageKey(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
