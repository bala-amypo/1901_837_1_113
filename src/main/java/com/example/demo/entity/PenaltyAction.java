package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class PenaltyAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String penaltyType;
    private String remarks;

    @ManyToOne
    private IntegrityCase integrityCase;

    public PenaltyAction() {
    }

    public PenaltyAction(int id, String penaltyType,
                         String remarks, IntegrityCase integrityCase) {
        this.id = id;
        this.penaltyType = penaltyType;
        this.remarks = remarks;
        this.integrityCase = integrityCase;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getPenaltyType() {
        return penaltyType;
    }
    public void setPenaltyType(String penaltyType) {
        this.penaltyType = penaltyType;
    }

    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public IntegrityCase getIntegrityCase() {
        return integrityCase;
    }
    public void setIntegrityCase(IntegrityCase integrityCase) {
        this.integrityCase = integrityCase;
    }
}
