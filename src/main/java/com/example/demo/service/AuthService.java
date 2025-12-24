package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service  
public class AuthService {

    public String login(String username, String password) {
        // Temporary logic
        if ("admin".equals(username) && "admin123".equals(password)) {
            return "LOGIN_SUCCESS";
        }
        return "INVALID_CREDENTIALS";
    }
}
