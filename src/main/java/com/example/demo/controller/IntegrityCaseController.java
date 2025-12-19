package com.example.demo.controller;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.service.IntegrityCaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cases")
public class IntegrityCaseController {

    private final IntegrityCaseService integrityCaseService;

    public IntegrityCaseController(IntegrityCaseService integrityCaseService) {
        this.integrityCaseService = integrityCaseService;
    }

    @PostMapping
    public IntegrityCase createCase(@RequestBody IntegrityCase integrityCase) {
        return integrityCaseService.createCase(integrityCase);
    }

    @PutMapping("/{caseId}/status")
    public IntegrityCase updateCaseStatus(
            @PathVariable Long caseId,
            @RequestParam String status) {

        return integrityCaseService.updateCaseStatus(caseId, status);
    }

    @GetMapping("/student/{studentId}")
    public List<IntegrityCase> getCasesByStudent(@PathVariable Long studentId) {
        return integrityCaseService.getCasesByStudent(studentId);
    }

    @GetMapping("/{caseId}")
    public Optional<IntegrityCase> getCaseById(@PathVariable Long caseId) {
        return integrityCaseService.getCaseById(caseId);
    }
}
