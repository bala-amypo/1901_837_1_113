package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "penalty_actions")
public class PenaltyAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "integrity_case_id")
    private IntegrityCase integrityCase;

    @Column(nullable = false)
    private String penaltyType;

    @Column(length = 1000)
    private String details;

    private String issuedBy;

    @Column(nullable = false)
    private LocalDateTime issuedAt;

    public PenaltyAction() {
        this.issuedAt = LocalDateTime.now();
    }

    // getters and setters
}
