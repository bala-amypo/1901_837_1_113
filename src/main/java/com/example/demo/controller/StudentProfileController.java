package com.example.demo.controller;

import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentProfileController {

    private final StudentProfileService studentProfileService;

    public StudentProfileController(StudentProfileService studentProfileService) {
        this.studentProfileService = studentProfileService;
    }

    @PostMapping
    public StudentProfile createStudent(@RequestBody StudentProfile studentProfile) {
        return studentProfileService.createStudent(studentProfile);
    }

    @GetMapping("/{id}")
    public StudentProfile getStudentById(@PathVariable Long id) {
        return studentProfileService.getStudentById(id);
    }

    @GetMapping
    public List<StudentProfile> getAllStudents() {
        return studentProfileService.getAllStudents();
    }

    @PutMapping("/{id}/repeat-status")
    public StudentProfile updateRepeatStatus(@PathVariable Long id) {
        return studentProfileService.updateRepeatOffenderStatus(id);
    }
}
