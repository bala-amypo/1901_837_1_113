package com.example.demo.controller;

import com.example.demo.entity.PenaltyAction;
import com.example.demo.service.PenaltyActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/penalties")
public class PenaltyActionController {

    @Autowired
    private PenaltyActionService penaltyActionService;

    @GetMapping
    public ResponseEntity<List<PenaltyAction>> getAllPenalties() {
        return ResponseEntity.ok(penaltyActionService.getAllPenalties());
    }

    @PostMapping
    public ResponseEntity<PenaltyAction> addPenalty(@RequestBody PenaltyAction penaltyAction) {
        return ResponseEntity.ok(penaltyActionService.addPenalty(penaltyAction));
    }
}
