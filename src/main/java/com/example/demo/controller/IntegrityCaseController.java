package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.IntegrityCase;
import com.example.demo.service.IntegrityCaseService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cases")
public class IntegrityCaseController {

    private final IntegrityCaseService integrityCaseService;

    public IntegrityCaseController(IntegrityCaseService integrityCaseService) {
        this.integrityCaseService = integrityCaseService;
    }

    /**
     * POST /cases
     */
    @PostMapping
    public ResponseEntity<IntegrityCase> createCase(
            @RequestBody IntegrityCase integrityCase) {

        return ResponseEntity.ok(
                integrityCaseService.createCase(integrityCase)
        );
    }

    /**
     * PUT /cases/{id}/status
     */
    @PutMapping("/{id}/status")
    public ResponseEntity<IntegrityCase> updateCaseStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return ResponseEntity.ok(
                integrityCaseService.updateCaseStatus(id, status)
        );
    }

    /**
     * GET /cases/student/{studentId}
     */
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<IntegrityCase>> getCasesByStudent(
            @PathVariable Long studentId) {

        return ResponseEntity.ok(
                integrityCaseService.getCasesByStudent(studentId)
        );
    }

    /**
     * GET /cases/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<IntegrityCase> getCaseById(
            @PathVariable Long id) {

        return integrityCaseService.getCaseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
