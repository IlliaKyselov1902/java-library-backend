package com.example.library.authentication;

import com.example.library.model.dto.AuthenticationDTO;
import com.example.library.model.request.UserRegistrationRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AuthenticationController {
    AuthenticationService authService;
    @PostMapping("/auth/registration")
    @ResponseStatus(HttpStatus.OK)
    public AuthenticationDTO registration(@Valid @RequestBody UserRegistrationRequest request) {
        return authService.register(request);
    }

    @PostMapping("/auth/login")
    @ResponseStatus(HttpStatus.OK)
    public AuthenticationDTO login(@Valid Authentication authentication) {
        return authService.login(authentication.getName());
    }

    @GetMapping("/auth/logout")
    @ResponseStatus(HttpStatus.OK)
    public void logout(Authentication authentication) {
        authService.logout(authentication.getName());
    }
}
