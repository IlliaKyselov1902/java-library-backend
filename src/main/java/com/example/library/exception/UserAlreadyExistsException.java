package com.example.library.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException() {
        super("User with such credentials already exists");
    }

}
