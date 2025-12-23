package com.example.demo.controller;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.service.IntegrityCaseService;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cases")
@Tag(name = "Integrity Cases")
public class IntegrityCaseController {

    private final IntegrityCaseService integrityCaseService;

    public IntegrityCaseController(IntegrityCaseService integrityCaseService) {
        this.integrityCaseService = integrityCaseService;
    }

    // POST /
    @PostMapping
    public ResponseEntity<IntegrityCase> createCase(
            @RequestBody IntegrityCase integrityCase) {
        return ResponseEntity.ok(
                integrityCaseService.createCase(integrityCase)
        );
    }

    // PUT /{id}/status
    @PutMapping("/{id}/status")
    public ResponseEntity<IntegrityCase> updateCaseStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return ResponseEntity.ok(
                integrityCaseService.updateCaseStatus(id, status)
        );
    }

    // GET /student/{studentId}
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<IntegrityCase>> getCasesByStudent(
            @PathVariable Long studentId) {

        return ResponseEntity.ok(
                integrityCaseService.getCasesByStudent(studentId)
        );
    }

    // GET /{id}
    @GetMapping("/{id}")
    public ResponseEntity<IntegrityCase> getCaseById(
            @PathVariable Long id) {

        return integrityCaseService.getCaseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /
    @GetMapping
    public ResponseEntity<List<IntegrityCase>> getAllCases() {
        return ResponseEntity.ok(
                integrityCaseService.getAllCases()
        );
    }
}
