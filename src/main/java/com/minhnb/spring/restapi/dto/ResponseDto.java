package com.minhnb.spring.restapi.dto;

public class ResponseDto<T> {

    private T data;
    private StatusDto statusDto;

    public ResponseDto() {
    }

    public ResponseDto(T data, StatusDto statusDto) {
        this.data = data;
        this.statusDto = statusDto;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public StatusDto getStatusDto() {
        return statusDto;
    }

    public void setStatusDto(StatusDto statusDto) {
        this.statusDto = statusDto;
    }

}
