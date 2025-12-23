package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@Tag(name = "Student Profiles")
public class StudentProfileController {

    private final StudentProfileService studentProfileService;

    public StudentProfileController(StudentProfileService studentProfileService) {
        this.studentProfileService = studentProfileService;
    }

    // POST /
    @PostMapping
    public ResponseEntity<StudentProfile> createStudent(
            @RequestBody StudentProfile studentProfile) {
        return ResponseEntity.ok(
                studentProfileService.createStudent(studentProfile)
        );
    }

    // GET /{id}
    @GetMapping("/{id}")
    public ResponseEntity<StudentProfile> getStudentById(
            @PathVariable Long id) {
        return ResponseEntity.ok(
                studentProfileService.getStudentById(id)
        );
    }

    // GET /
    @GetMapping
    public ResponseEntity<List<StudentProfile>> getAllStudents() {
        return ResponseEntity.ok(
                studentProfileService.getAllStudents()
        );
    }

    // PUT /{studentId}/repeat-status
    @PutMapping("/{studentId}/repeat-status")
    public ResponseEntity<ApiResponse> updateRepeatStatus(
            @PathVariable Long studentId) {

        studentProfileService.updateRepeatOffenderStatus(studentId);
        return ResponseEntity.ok(
                new ApiResponse(true, "Repeat offender status updated")
        );
    }

    // GET /lookup/{studentId}
    @GetMapping("/lookup/{studentId}")
    public ResponseEntity<StudentProfile> findByStudentIdentifier(
            @PathVariable String studentId) {

        return ResponseEntity.ok(
                studentProfileService.getStudentByStudentIdentifier(studentId)
        );
    }
}
