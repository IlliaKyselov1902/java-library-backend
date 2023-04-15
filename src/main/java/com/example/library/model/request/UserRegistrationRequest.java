package com.example.library.model.request;

public record UserRegistrationRequest (
    String name,
    String surname,
    String email,
    String password
){}
