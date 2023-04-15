package com.example.library.authentication;

import com.example.library.exception.UserAlreadyExistsException;
import com.example.library.exception.UserNotFoundException;
import com.example.library.model.dto.AuthenticationDTO;
import com.example.library.model.entity.User;
import com.example.library.model.request.UserRegistrationRequest;
import com.example.library.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{
    private final JwtEncoder jwtEncoder;
    private UserRepository userRepository;
    private Map<String, String> validTokens;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthenticationDTO register(UserRegistrationRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new UserAlreadyExistsException();
        }
        User newUser = User.builder()
                .name(request.name())
                .surname(request.surname())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .build();

        User savedUser = userRepository.save(newUser);

        Instant now = Instant.now();

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("Library admin")
                .issuedAt(now)
                .expiresAt(now.plus(45, ChronoUnit.MINUTES))
                .subject(savedUser.getEmail())
                .claim("user_id", savedUser.getId())
                .build();
        validTokens.put(savedUser.getEmail(), jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue());
        return new AuthenticationDTO(jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue());
    }
    @Override
    public AuthenticationDTO login(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
        Instant now = Instant.now();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("Library admin")
                .issuedAt(now)
                .expiresAt(now.plus(45, ChronoUnit.MINUTES))
                .subject(email)
                .claim("user_id", user.getId())
                .build();
        validTokens.put(email, jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue());
        return new AuthenticationDTO(jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue());
    }
    @Override
    public void logout(String email) {
        if (validTokens.containsKey(email)) {
            validTokens.entrySet().removeIf(entry -> entry.getKey().equals(email));
        }
        else {
            throw new UserNotFoundException();
        }
    }
}
