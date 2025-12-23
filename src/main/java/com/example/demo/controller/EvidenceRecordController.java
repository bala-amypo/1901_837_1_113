package com.example.demo.controller;

import com.example.demo.entity.EvidenceRecord;
import com.example.demo.service.EvidenceRecordService;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evidence")
@Tag(name = "Evidence Records")
public class EvidenceRecordController {

    private final EvidenceRecordService evidenceRecordService;

    public EvidenceRecordController(EvidenceRecordService evidenceRecordService) {
        this.evidenceRecordService = evidenceRecordService;
    }

    // POST /
    @PostMapping
    public ResponseEntity<EvidenceRecord> submitEvidence(
            @RequestBody EvidenceRecord evidenceRecord) {

        return ResponseEntity.ok(
                evidenceRecordService.submitEvidence(evidenceRecord)
        );
    }

    // GET /case/{caseId}
    @GetMapping("/case/{caseId}")
    public ResponseEntity<List<EvidenceRecord>> getEvidenceByCase(
            @PathVariable Long caseId) {

        return ResponseEntity.ok(
                evidenceRecordService.getEvidenceByCase(caseId)
        );
    }

    // GET /{id}
    @GetMapping("/{id}")
    public ResponseEntity<EvidenceRecord> getEvidenceById(
            @PathVariable Long id) {

        return evidenceRecordService.getEvidenceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /
    @GetMapping
    public ResponseEntity<List<EvidenceRecord>> getAllEvidence() {
        return ResponseEntity.ok(
                evidenceRecordService.getAllEvidence()
        );
    }
}
