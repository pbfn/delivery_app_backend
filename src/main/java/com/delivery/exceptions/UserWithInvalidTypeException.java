package com.delivery.exceptions;

public class UserWithInvalidTypeException extends RuntimeException {

    public UserWithInvalidTypeException(String msg){
        super(msg);
    }
}
