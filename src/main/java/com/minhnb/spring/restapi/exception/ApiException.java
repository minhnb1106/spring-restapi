package com.minhnb.spring.restapi.exception;

import com.minhnb.spring.restapi.dto.StatusDto;

import java.io.Serializable;

public class ApiException extends Exception implements Serializable {

    private static final long serialVersionUID = -2550185165626007488L;

    private StatusDto statusDto;

    public ApiException(StatusDto statusDto) {
        this.statusDto = statusDto;
    }

    public StatusDto getStatusDto() {
        return statusDto;
    }

    public void setStatusDto(StatusDto statusDto) {
        this.statusDto = statusDto;
    }

}
