package com.example.demo.service;

import com.example.demo.entity.PenaltyAction;
import java.util.List;

public interface PenaltyActionService {
    List<PenaltyAction> getPenaltiesByCase(Long caseId);
    PenaltyAction getPenaltyById(Long id);
    List<PenaltyAction> getAllPenalties();
}
