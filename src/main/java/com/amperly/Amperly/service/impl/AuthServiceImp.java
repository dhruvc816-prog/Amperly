package com.amperly.Amperly.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.amperly.Amperly.dto.*;

import com.amperly.Amperly.entity.*;

import com.amperly.Amperly.repo.userRepo;
import com.amperly.Amperly.service.AuthService;
import com.amperly.Amperly.util.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImp implements AuthService {

        private final userRepo userRepo;
        private final PasswordEncoder passwordEncoder;
        private final JwtUtil jwtUtil;
        private final AuthenticationManager authenticationManager;

        @Override
        public AuthResponse register(RegisterRequest request) {
                if (userRepo.existsByEmail(request.getEmail()))
                        throw new RuntimeException("Email Already Registered!!!!!");

                var user = User.builder()
                                .fullName(request.getFullName())
                                .email(request.getEmail())
                                .phone(request.getPhone())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .state(request.getState())
                                .role(Role.USER)
                                .isActive(true)
                                .build();

                userRepo.save(user);
                return new AuthResponse(jwtUtil.generateToken(user.getEmail()),
                                user.getEmail(),
                                user.getRole().name(),
                                "User Registered Successfully");

        }

        @Override
        public AuthResponse login(LoginRequest request) {

                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

                var user = userRepo.findByEmail(request.getEmail())
                                .orElseThrow(() -> new RuntimeException("User not found"));

                return new AuthResponse(jwtUtil.generateToken(user.getEmail()),
                                user.getEmail(), user.getRole().name(), "Login Successfully");

        }

}
