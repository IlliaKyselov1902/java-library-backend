package com.example.library.authentication;

import com.example.library.model.dto.AuthenticationDTO;
import com.example.library.model.request.UserRegistrationRequest;

public interface AuthenticationService {
    AuthenticationDTO login(String email);

    AuthenticationDTO register(UserRegistrationRequest request);

    void logout(String email);
}
