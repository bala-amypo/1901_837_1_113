package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "evidence_records")
public class EvidenceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String evidenceType;
    private String description;

    @ManyToOne
    @JoinColumn(name = "case_id")
    private IntegrityCase integrityCase;

    public EvidenceRecord() {}

    public Long getId() { return id; }

    public String getEvidenceType() {
        return evidenceType;
    }

    public void setEvidenceType(String evidenceType) {
        this.evidenceType = evidenceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IntegrityCase getIntegrityCase() {
        return integrityCase;
    }

    public void setIntegrityCase(IntegrityCase integrityCase) {
        this.integrityCase = integrityCase;
    }
}
