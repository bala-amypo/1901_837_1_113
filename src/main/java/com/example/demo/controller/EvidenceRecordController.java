package com.example.demo.controller;

import com.example.demo.entity.EvidenceRecord;
import com.example.demo.service.EvidenceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/evidence")
public class EvidenceRecordController {

    @Autowired
    private EvidenceRecordService evidenceRecordService;

    @GetMapping
    public ResponseEntity<List<EvidenceRecord>> getAllEvidence() {
        return ResponseEntity.ok(evidenceRecordService.getAllEvidence());
    }

    @PostMapping
    public ResponseEntity<EvidenceRecord> submitEvidence(@RequestBody EvidenceRecord evidenceRecord) {
        return ResponseEntity.ok(evidenceRecordService.submitEvidence(evidenceRecord));
    }
}
