package com.example.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BasicServlet", urlPatterns = "/api/servlet/basic")
public class BasicServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Handles GET requests
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/plain");
        resp.setStatus(HttpServletResponse.SC_OK);

        PrintWriter writer = resp.getWriter();
        writer.println("GET request received");
        writer.flush();
    }

    // Handles POST requests
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("application/json");
        resp.setStatus(HttpServletResponse.SC_OK);

        PrintWriter writer = resp.getWriter();
        writer.println("{\"success\":true,\"message\":\"POST request received\"}");
        writer.flush();
    }
}
