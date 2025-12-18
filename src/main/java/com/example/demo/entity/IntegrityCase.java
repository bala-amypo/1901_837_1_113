package com.example.demo.entity;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
public class IntegrityCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String courseCode;
    private String description;
    private LocalDate incidentDate;
    private String status;

    @ManyToOne
    private StudentProfile studentProfile;

    public IntegrityCase() {
    }

    public IntegrityCase(int id, String courseCode, String description,
                         LocalDate incidentDate, String status,
                         StudentProfile studentProfile) {
        this.id = id;
        this.courseCode = courseCode;
        this.description = description;
        this.incidentDate = incidentDate;
        this.status = status;
        this.studentProfile = studentProfile;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getIncidentDate() {
        return incidentDate;
    }
    public void setIncidentDate(LocalDate incidentDate) {
        this.incidentDate = incidentDate;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }
    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }
}
