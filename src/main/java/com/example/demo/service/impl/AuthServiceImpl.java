package com.example.demo.service.impl;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public String register(RegisterRequest request) {
        return "User registered successfully";
    }

    @Override
    public JwtResponse login(LoginRequest request) {
        // Temporary token for compilation & testing
        return new JwtResponse("dummy-jwt-token");
    }
}
