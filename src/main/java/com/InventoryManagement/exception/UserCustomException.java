package com.InventoryManagement.exception;

import org.springframework.http.HttpStatus;

public class UserCustomException extends RuntimeException{
    private final HttpStatus httpStatus;
    public UserCustomException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
