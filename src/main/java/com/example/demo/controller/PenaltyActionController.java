package com.example.demo.controller;

import com.example.demo.entity.PenaltyAction;
import com.example.demo.service.PenaltyActionService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/penalties")
public class PenaltyActionController {

    private final PenaltyActionService penaltyActionService;

    public PenaltyActionController(PenaltyActionService penaltyActionService) {
        this.penaltyActionService = penaltyActionService;
    }

    @PostMapping
    public ResponseEntity<PenaltyAction> addPenalty(
            @RequestBody PenaltyAction penaltyAction) {

        return ResponseEntity.ok(
                penaltyActionService.addPenalty(penaltyAction)
        );
    }
}
