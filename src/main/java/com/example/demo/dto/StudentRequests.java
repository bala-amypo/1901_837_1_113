package com.example.demo.dto;

import lombok.*;

import java.util.List;
@Data
public class StudentRequests {
    private String studentId;
    private String name;
    private String email;
    private String program;
    private Integer yearLevel;
    private Boolean repeatOffender;
    private List integrityCases;
}
