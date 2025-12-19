package com.example.demo.controller;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.service.RepeatOffenderRecordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/repeat-offender")
public class RepeatOffenderRecordController {

    private final RepeatOffenderRecordService repeatOffenderRecordService;

    public RepeatOffenderRecordController(RepeatOffenderRecordService repeatOffenderRecordService) {
        this.repeatOffenderRecordService = repeatOffenderRecordService;
    }

    @GetMapping("/{studentId}")
    public RepeatOffenderRecord getOrUpdateRepeatOffender(@PathVariable Long studentId) {
        // Recalculate and return the repeat offender record
        return repeatOffenderRecordService.recalculateAndGet(studentId);
    }
}
