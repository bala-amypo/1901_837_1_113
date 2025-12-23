package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "penalty_actions")
public class PenaltyAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    @ManyToOne
    private IntegrityCase integrityCase;

    // Getters & Setters
    public Long getId() { return id; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public IntegrityCase getIntegrityCase() { return integrityCase; }
    public void setIntegrityCase(IntegrityCase integrityCase) { this.integrityCase = integrityCase; }
}
