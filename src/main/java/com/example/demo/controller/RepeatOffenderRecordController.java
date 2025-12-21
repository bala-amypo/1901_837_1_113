package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.service.RepeatOffenderRecordService;
import com.example.demo.service.StudentProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/repeat-offenders")
public class RepeatOffenderRecordController {
    private final RepeatOffenderRecordService repeatOffenderRecordService;
    private final StudentProfileService studentProfileService;
    
    public RepeatOffenderRecordController(RepeatOffenderRecordService repeatOffenderRecordService,
                                        StudentProfileService studentProfileService) {
        this.repeatOffenderRecordService = repeatOffenderRecordService;
        this.studentProfileService = studentProfileService;
    }
    
    @GetMapping("/{studentId}")
    public ResponseEntity<ApiResponse> getRepeatOffenderRecord(@PathVariable Long studentId) {
        StudentProfile student = studentProfileService.getStudentById(studentId);
        RepeatOffenderRecord record = repeatOffenderRecordService.recalculateRecord(student);
        return ResponseEntity.ok(new ApiResponse(true, "Record recalculated", record));
    }
}
