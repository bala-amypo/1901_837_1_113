package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "student_profiles")
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean repeatOffender;
    private LocalDateTime createdAt;

    // Getters & Setters
    public Long getId() { return id; }
    public boolean isRepeatOffender() { return repeatOffender; }
    public void setRepeatOffender(boolean repeatOffender) { this.repeatOffender = repeatOffender; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
