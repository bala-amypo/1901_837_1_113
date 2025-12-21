package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import lombok.*;
@Entity
@Data
@Table(name = "student_profiles")

public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String studentId;

    private String name;
    private String email;
    private String program;

    @Column(nullable = false)
    private Integer yearLevel;

    private Boolean repeatOffender = false;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "studentProfile")
    private List<IntegrityCase> integrityCases;

    public StudentProfile() {}

    public StudentProfile(String studentId, String name, String email) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
    }

    @PrePersist
    protected void onCreate() { this.createdAt = LocalDateTime.now(); }

    public Long getId() { return id; }
    public Boolean getRepeatOffender() { return repeatOffender; }
    public void setRepeatOffender(Boolean repeatOffender) { this.repeatOffender = repeatOffender; }
}
