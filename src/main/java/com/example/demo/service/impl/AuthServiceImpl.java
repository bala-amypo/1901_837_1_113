package com.example.demo.service.impl;

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
    public String login(LoginRequest request) {
        return "Login successful";
    }
}
