package com.example.demo.service.impl;

import com.example.demo.entity.PenaltyAction;
import com.example.demo.repository.PenaltyActionRepository;
import com.example.demo.service.PenaltyActionService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PenaltyActionServiceImpl implements PenaltyActionService {

    private final PenaltyActionRepository penaltyActionRepository;

    public PenaltyActionServiceImpl(PenaltyActionRepository penaltyActionRepository) {
        this.penaltyActionRepository = penaltyActionRepository;
    }

    @Override
    public List<PenaltyAction> getAllPenalties() {
        return penaltyActionRepository.findAll();
    }

    @Override
    public PenaltyAction addPenalty(PenaltyAction penaltyAction) {
        return penaltyActionRepository.save(penaltyAction);
    }
}
