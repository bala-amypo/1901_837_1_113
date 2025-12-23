package com.example.demo.service;

import com.example.demo.entity.StudentProfile;
import java.util.List;
import java.util.Optional;

public interface StudentProfileService {
    StudentProfile createStudent(StudentProfile studentProfile);
    Optional<StudentProfile> getStudentById(Long id);
    List<StudentProfile> getAllStudents();
    void updateRepeatOffenderStatus(Long studentId);
}
