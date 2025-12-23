package com.example.demo.service.impl;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.PenaltyAction;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.PenaltyActionRepository;
import com.example.demo.service.PenaltyActionService;

public class PenaltyActionServiceImpl implements PenaltyActionService {

    private final PenaltyActionRepository penaltyActionRepository;
    private final IntegrityCaseRepository integrityCaseRepository;

    public PenaltyActionServiceImpl(
            PenaltyActionRepository penaltyActionRepository,
            IntegrityCaseRepository integrityCaseRepository) {

        this.penaltyActionRepository = penaltyActionRepository;
        this.integrityCaseRepository = integrityCaseRepository;
    }

    @Override
    public PenaltyAction addPenalty(PenaltyAction penaltyAction) {

        Long caseId = penaltyAction.getIntegrityCase().getId();

        IntegrityCase integrityCase =
                integrityCaseRepository.findById(caseId)
                        .orElseThrow(() -> new IllegalArgumentException("case not found"));

        integrityCase.setStatus("UNDER_REVIEW");
        penaltyAction.setIntegrityCase(integrityCase);

        return penaltyActionRepository.save(penaltyAction);
    }
}
