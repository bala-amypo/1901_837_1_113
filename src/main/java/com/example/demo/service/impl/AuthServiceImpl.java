package com.example.demo.service.impl;

import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public String login(String username, String password) {
        // TODO: replace with real authentication logic
        if ("admin".equals(username) && "admin".equals(password)) {
            return "Login successful";
        }
        return "Invalid credentials";
    }
}
