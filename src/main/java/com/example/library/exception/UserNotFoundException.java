package com.example.library.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("User can't be found");
    }
}
