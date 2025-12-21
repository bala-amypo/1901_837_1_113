package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.EvidenceRecord;
import com.example.demo.service.EvidenceRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evidence")
public class EvidenceRecordController {
    private final EvidenceRecordService evidenceRecordService;
    
    public EvidenceRecordController(EvidenceRecordService evidenceRecordService) {
        this.evidenceRecordService = evidenceRecordService;
    }
    
    @PostMapping
    public ResponseEntity<ApiResponse> submitEvidence(@RequestBody EvidenceRecord evidenceRecord) {
        EvidenceRecord created = evidenceRecordService.submitEvidence(evidenceRecord);
        return ResponseEntity.ok(new ApiResponse(true, "Evidence submitted successfully", created));
    }
}
