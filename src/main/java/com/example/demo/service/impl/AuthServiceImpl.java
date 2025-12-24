package com.example.demo.service.impl;

import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

@Service   
public class AuthServiceImpl implements AuthService {

    @Override
    public String login(String username, String password) {
        if ("admin".equals(username) && "admin123".equals(password)) {
            return "LOGIN_SUCCESS";
        }
        return "INVALID_CREDENTIALS";
    }

    @Override
    public String register(String username, String password) {
        return "USER_REGISTERED";
    }
}
