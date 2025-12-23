package com.example.demo.controller;

import com.example.demo.entity.PenaltyAction;
import com.example.demo.service.PenaltyActionService;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/penalties")
@Tag(name = "Penalty Actions")
public class PenaltyActionController {

    private final PenaltyActionService penaltyActionService;

    public PenaltyActionController(PenaltyActionService penaltyActionService) {
        this.penaltyActionService = penaltyActionService;
    }

    // POST /
    @PostMapping
    public ResponseEntity<PenaltyAction> addPenalty(
            @RequestBody PenaltyAction penaltyAction) {

        return ResponseEntity.ok(
                penaltyActionService.addPenalty(penaltyAction)
        );
    }

    // GET /case/{caseId}
    @GetMapping("/case/{caseId}")
    public ResponseEntity<List<PenaltyAction>> getPenaltiesByCase(
            @PathVariable Long caseId) {

        return ResponseEntity.ok(
                penaltyActionService.getPenaltiesByCase(caseId)
        );
    }

    // GET /{id}
    @GetMapping("/{id}")
    public ResponseEntity<PenaltyAction> getPenaltyById(
            @PathVariable Long id) {

        return penaltyActionService.getPenaltyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /
    @GetMapping
    public ResponseEntity<List<PenaltyAction>> getAllPenalties() {
        return ResponseEntity.ok(
                penaltyActionService.getAllPenalties()
        );
    }
}
