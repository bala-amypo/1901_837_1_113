package com.example.demo.service;

import com.example.demo.entity.StudentRequest;
import java.util.List;

public interface StudentProfileService {
    StudentProfile createStudent(StudentProfile studentProfile);
    StudentProfile getStudentById(Long id);
    List<StudentProfile> getAllStudents();
    StudentProfile updateRepeatOffenderStatus(Long studentId);
}
