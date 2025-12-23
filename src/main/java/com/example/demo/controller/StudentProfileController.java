package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentProfileController {

    private final StudentProfileService studentProfileService;

    public StudentProfileController(StudentProfileService studentProfileService) {
        this.studentProfileService = studentProfileService;
    }

    /**
     * POST /students
     */
    @PostMapping
    public ResponseEntity<StudentProfile> createStudent(
            @RequestBody StudentProfile studentProfile) {

        return ResponseEntity.ok(
                studentProfileService.createStudent(studentProfile)
        );
    }

    /**
     * GET /students/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<StudentProfile> getStudentById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                studentProfileService.getStudentById(id)
        );
    }

    /**
     * GET /students
     */
    @GetMapping
    public ResponseEntity<List<StudentProfile>> getAllStudents() {
        return ResponseEntity.ok(
                studentProfileService.getAllStudents()
        );
    }

    /**
     * PUT /students/{id}/repeat-offender
     */
    @PutMapping("/{id}/repeat-offender")
    public ResponseEntity<ApiResponse> updateRepeatOffenderStatus(
            @PathVariable Long id) {

        studentProfileService.updateRepeatOffenderStatus(id);

        return ResponseEntity.ok(
                new ApiResponse(true, "Repeat offender status updated")
        );
    }
}
