package com.example.demo.controller;

import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentProfileController {

    @Autowired
    private StudentProfileService studentProfileService;

    @GetMapping
    public ResponseEntity<List<StudentProfile>> getAllStudents() {
        return ResponseEntity.ok(studentProfileService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentProfile> getStudentById(@PathVariable Long id) {
        return studentProfileService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StudentProfile> createStudent(@RequestBody StudentProfile studentProfile) {
        return ResponseEntity.ok(studentProfileService.createStudent(studentProfile));
    }

    @PutMapping("/{id}/repeat-offender")
    public ResponseEntity<Void> updateRepeatOffenderStatus(@PathVariable Long id) {
        studentProfileService.updateRepeatOffenderStatus(id);
        return ResponseEntity.ok().build();
    }
}
