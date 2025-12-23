package com.example.demo.service;

import com.example.demo.entity.StudentProfile;

public interface StudentProfileService {
    StudentProfile getStudentByStudentIdentifier(String identifier);
    void updateRepeatOffenderStatus(Long studentId);
}
