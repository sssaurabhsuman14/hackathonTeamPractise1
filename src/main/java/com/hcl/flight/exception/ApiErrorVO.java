package com.hcl.flight.exception;

public class ApiErrorVO {
 
    private String errorCode;
    private String message;
 
    public ApiErrorVO(String errorCode, String message) {
        super();
        this.errorCode = errorCode;
        this.message = message;
    }
}

