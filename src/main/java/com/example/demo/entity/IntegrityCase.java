package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.*;

@Data
@Entity
@Table(name = "integrity_cases")
public class IntegrityCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private StudentProfile studentProfile;

    private String courseCode;
    private String instructorName;

    @Column(length = 1000)
    private String description;

    private String status = "OPEN";

    private LocalDate incidentDate;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "integrityCase")
    private List<EvidenceRecord> evidenceRecords;

    @OneToMany(mappedBy = "integrityCase")
    private List<PenaltyAction> penaltyActions;

    @PrePersist
    protected void onCreate() { createdAt = LocalDateTime.now(); }

    public Long getId() { return id; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public StudentProfile getStudentProfile() { return studentProfile; }
    public void setStudentProfile(StudentProfile studentProfile) { this.studentProfile = studentProfile; }
}
