package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "integrity_cases")
public class IntegrityCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    @ManyToOne
    private StudentProfile studentProfile;

    // Getters & Setters
    public Long getId() { return id; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public StudentProfile getStudentProfile() { return studentProfile; }
    public void setStudentProfile(StudentProfile studentProfile) { this.studentProfile = studentProfile; }
}
