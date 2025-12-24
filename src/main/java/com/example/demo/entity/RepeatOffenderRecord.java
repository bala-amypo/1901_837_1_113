package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "repeat_offender_records")
public class RepeatOffenderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int totalCases;
    private String flagSeverity;

    @OneToOne
    @JoinColumn(name = "student_profile_id")
    private StudentProfile studentProfile;

    public RepeatOffenderRecord() {}

    public Long getId() { return id; }

    public int getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(int totalCases) {
        this.totalCases = totalCases;
    }

    public String getFlagSeverity() {
        return flagSeverity;
    }

    public void setFlagSeverity(String flagSeverity) {
        this.flagSeverity = flagSeverity;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }
}
