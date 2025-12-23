package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "integrity_cases")
public class IntegrityCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_profile_id")
    private StudentProfile studentProfile;

    @Column(nullable = false)
    private String courseCode;

    private String instructorName;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private String status = "OPEN";

    private LocalDate incidentDate;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(
        mappedBy = "integrityCase",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<EvidenceRecord> evidenceRecords = new ArrayList<>();

    @OneToMany(
        mappedBy = "integrityCase",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<PenaltyAction> penaltyActions = new ArrayList<>();

    public IntegrityCase() {
        this.createdAt = LocalDateTime.now();
        this.status = "OPEN";
    }

    // getters and setters
}
