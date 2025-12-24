package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "penalty_actions")
public class PenaltyAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String actionType;
    private String remarks;

    @ManyToOne
    @JoinColumn(name = "case_id")
    private IntegrityCase integrityCase;

    public PenaltyAction() {}

    public Long getId() { return id; }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
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
