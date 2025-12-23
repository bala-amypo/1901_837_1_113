 package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "evidence_records")
public class EvidenceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "integrity_case_id")
    private IntegrityCase integrityCase;

    @Column(nullable = false)
    private String evidenceType;

    @Column(nullable = false, length = 2000)
    private String content;

    private String submittedBy;

    @Column(nullable = false)
    private LocalDateTime submittedAt;

    public EvidenceRecord() {
        this.submittedAt = LocalDateTime.now();
    }

    // getters and setters
}
