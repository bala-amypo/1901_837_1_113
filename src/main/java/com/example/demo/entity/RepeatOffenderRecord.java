package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class RepeatOffenderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int totalCases;
    private String severity;

    @OneToOne
    private StudentProfile studentProfile;

    public RepeatOffenderRecord() {
    }

    public RepeatOffenderRecord(int id, int totalCases,
                                String severity, StudentProfile studentProfile) {
        this.id = id;
        this.totalCases = totalCases;
        this.severity = severity;
        this.studentProfile = studentProfile;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getTotalCases() {
        return totalCases;
    }
    public void setTotalCases(int totalCases) {
        this.totalCases = totalCases;
    }

    public String getSeverity() {
        return severity;
    }
    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }
    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }
}
