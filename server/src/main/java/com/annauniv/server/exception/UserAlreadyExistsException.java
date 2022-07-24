package com.annauniv.server.exception;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String msg, Throwable cause) {
        super(msg, cause);
    }
    public UserAlreadyExistsException(String msg) {
        super(msg);
    }
}
