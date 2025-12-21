package com.example.demo.service;

import com.example.demo.dto.StudentRequests;
import com.example.demo.entity.StudentProfile;
import java.util.List;

public interface StudentProfileService {
    StudentProfile createStudent(StudentRequests studentProfile);
    StudentProfile getStudentById(Long id);
    List<StudentProfile> getAllStudents();
    StudentProfile updateRepeatOffenderStatus(Long studentId);
}
