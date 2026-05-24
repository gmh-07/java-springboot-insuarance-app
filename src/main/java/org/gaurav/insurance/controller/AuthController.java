package org.gaurav.insurance.controller;

import lombok.RequiredArgsConstructor;
import org.gaurav.insurance.dto.*;
import org.gaurav.insurance.entity.User;
import org.gaurav.insurance.enums.Role;
import org.gaurav.insurance.repository.UserRepository;
import org.gaurav.insurance.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    @PostMapping("/register")
    public String register(
            @RequestBody RegisterRequest request
    ) {

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(
                        passwordEncoder.encode(
                                request.getPassword()
                        )
                )
                .role(Role.valueOf(request.getRole()))
                .build();

        userRepository.save(user);

        return "User Registered Successfully";
    }

    @PostMapping("/login")
    public AuthResponse login(
            @RequestBody LoginRequest request
    ) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        boolean matches = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if (!matches) {
            throw new RuntimeException("Invalid Password");
        }

        String token =
                jwtService.generateToken(user.getEmail());

        return AuthResponse.builder()
                .token(token)
                .message("Login Successful")
                .build();
    }
}
