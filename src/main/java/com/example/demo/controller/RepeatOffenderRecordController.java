package com.example.demo.controller;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.service.RepeatOffenderRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/repeat-offenders")
public class RepeatOffenderRecordController {

    @Autowired
    private RepeatOffenderRecordService repeatOffenderRecordService;

    @GetMapping
    public ResponseEntity<List<RepeatOffenderRecord>> getAllRecords() {
        return ResponseEntity.ok(repeatOffenderRecordService.getAll());
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<RepeatOffenderRecord>> getByStudent(@PathVariable Long studentId) {
        StudentProfile studentProfile = new StudentProfile();
        studentProfile.setId(studentId);
        return ResponseEntity.ok(repeatOffenderRecordService.getByStudentProfile(studentProfile));
    }

    @PostMapping
    public ResponseEntity<RepeatOffenderRecord> createRecord(@RequestBody RepeatOffenderRecord record) {
        return ResponseEntity.ok(repeatOffenderRecordService.createRecord(record));
    }
}
