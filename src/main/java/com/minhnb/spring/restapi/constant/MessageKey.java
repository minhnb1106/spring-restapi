package com.minhnb.spring.restapi.constant;

public enum MessageKey {

    SUCCESS("success"),
    FAILURE("failure");

    private String message;

    MessageKey(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
