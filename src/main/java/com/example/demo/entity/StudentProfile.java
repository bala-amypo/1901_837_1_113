package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student_profiles")
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String studentId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    private String program;

    @Column(nullable = false)
    private Integer yearLevel;

    @Column(nullable = false)
    private Boolean repeatOffender = false;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(
        mappedBy = "studentProfile",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<IntegrityCase> integrityCases = new ArrayList<>();

    public StudentProfile() {
        this.createdAt = LocalDateTime.now();
        this.repeatOffender = false;
    }

    public StudentProfile(String studentId, String name, String email, String program, Integer yearLevel) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.program = program;
        this.yearLevel = yearLevel;
        this.repeatOffender = false;
        this.createdAt = LocalDateTime.now();
    }

    // getters and setters
}
