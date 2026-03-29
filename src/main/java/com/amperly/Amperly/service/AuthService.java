package com.amperly.Amperly.service;

import com.amperly.Amperly.dto.AuthResponse;
import com.amperly.Amperly.dto.LoginRequest;
import com.amperly.Amperly.dto.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);

}
