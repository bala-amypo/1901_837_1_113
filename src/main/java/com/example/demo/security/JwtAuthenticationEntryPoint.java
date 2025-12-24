package com.example.demo.security;

import jakarta.servlet.http.*;
import java.io.IOException;

public class JwtAuthenticationEntryPoint
        implements org.springframework.security.web.AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest req,
                         HttpServletResponse res,
                         org.springframework.security.core.AuthenticationException e)
            throws IOException {
        res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }
}
