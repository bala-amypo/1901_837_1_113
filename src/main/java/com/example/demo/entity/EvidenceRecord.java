package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class EvidenceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String evidenceType;
    private String content;

    @ManyToOne
    private IntegrityCase integrityCase;

    public EvidenceRecord() {
    }

    public EvidenceRecord(int id, String evidenceType,
                          String content, IntegrityCase integrityCase) {
        this.id = id;
        this.evidenceType = evidenceType;
        this.content = content;
        this.integrityCase = integrityCase;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getEvidenceType() {
        return evidenceType;
    }
    public void setEvidenceType(String evidenceType) {
        this.evidenceType = evidenceType;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public IntegrityCase getIntegrityCase() {
        return integrityCase;
    }
    public void setIntegrityCase(IntegrityCase integrityCase) {
        this.integrityCase = integrityCase;
    }
}
