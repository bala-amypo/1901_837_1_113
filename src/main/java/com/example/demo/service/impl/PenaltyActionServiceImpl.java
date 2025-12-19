package com.example.demo.service.impl;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.PenaltyAction;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.PenaltyActionRepository;
import com.example.demo.service.PenaltyActionService;
import org.springframework.stereotype.Service;

@Service
public class PenaltyActionServiceImpl implements PenaltyActionService {

    private final PenaltyActionRepository penaltyRepo;
    private final IntegrityCaseRepository caseRepo;

    public PenaltyActionServiceImpl(PenaltyActionRepository penaltyRepo,
                                    IntegrityCaseRepository caseRepo) {
        this.penaltyRepo = penaltyRepo;
        this.caseRepo = caseRepo;
    }

    @Override
    public PenaltyAction addPenalty(PenaltyAction penaltyAction) {
        Long caseId = penaltyAction.getIntegrityCase().getId();
        IntegrityCase ic = caseRepo.findById(caseId)
                .orElseThrow(() -> new IllegalArgumentException("IntegrityCase not found"));
        penaltyAction.setIntegrityCase(ic);
        ic.setStatus("UNDER_REVIEW");
        caseRepo.save(ic);
        return penaltyRepo.save(penaltyAction);
    }
}
