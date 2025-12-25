package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.*;

@Entity @Data
public class StudentProfile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentId;
    private String name;
    private String email;
    private String program;
    private Integer yearLevel;
    private Boolean repeatOffender = false;
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "studentProfile")
    private List<IntegrityCase> integrityCases = new ArrayList<>();
}