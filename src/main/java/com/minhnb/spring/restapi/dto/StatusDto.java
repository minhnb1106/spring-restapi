package com.minhnb.spring.restapi.dto;

import com.minhnb.spring.restapi.constant.ResponseMessageKey;
import org.springframework.http.HttpStatus;

public class StatusDto {

    private int httpCode;
    private HttpStatus httpStatus;
    private String type;
    private String message;

    public StatusDto() {
    }

    public StatusDto(HttpStatus httpStatus, String type, String message) {
        this.httpCode = httpStatus.value();
        this.httpStatus = httpStatus;
        this.type = type;
        this.message = message;
    }

    public StatusDto(HttpStatus httpStatus, ResponseMessageKey responseMessageKey) {
        this.httpCode = httpStatus.value();
        this.httpStatus = httpStatus;
        this.type = responseMessageKey.name();
        this.message = responseMessageKey.getMessage();
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
