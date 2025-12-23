package com.example.demo.controller;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.service.RepeatOffenderRecordService;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repeat-offenders")
@Tag(name = "Repeat Offenders")
public class RepeatOffenderRecordController {

    private final RepeatOffenderRecordService repeatOffenderRecordService;

    public RepeatOffenderRecordController(
            RepeatOffenderRecordService repeatOffenderRecordService) {
        this.repeatOffenderRecordService = repeatOffenderRecordService;
    }

    // POST /refresh/{studentId}
    @PostMapping("/refresh/{studentId}")
    public ResponseEntity<RepeatOffenderRecord> refreshRepeatOffender(
            @PathVariable Long studentId) {

        return ResponseEntity.ok(
                repeatOffenderRecordService.refreshRepeatOffender(studentId)
        );
    }

    // GET /student/{studentId}
    @GetMapping("/student/{studentId}")
    public ResponseEntity<RepeatOffenderRecord> getByStudent(
            @PathVariable Long studentId) {

        return ResponseEntity.ok(
                repeatOffenderRecordService.getByStudent(studentId)
        );
    }

    // GET /
    @GetMapping
    public ResponseEntity<List<RepeatOffenderRecord>> getAll() {
        return ResponseEntity.ok(
                repeatOffenderRecordService.getAll()
        );
    }
}
