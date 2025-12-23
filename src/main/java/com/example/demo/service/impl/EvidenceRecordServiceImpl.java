package com.example.demo.service.impl;

import com.example.demo.entity.EvidenceRecord;
import com.example.demo.entity.IntegrityCase;
import com.example.demo.repository.EvidenceRecordRepository;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.service.EvidenceRecordService;

public class EvidenceRecordServiceImpl implements EvidenceRecordService {

    private final EvidenceRecordRepository evidenceRecordRepository;
    private final IntegrityCaseRepository integrityCaseRepository;

    public EvidenceRecordServiceImpl(
            EvidenceRecordRepository evidenceRecordRepository,
            IntegrityCaseRepository integrityCaseRepository) {

        this.evidenceRecordRepository = evidenceRecordRepository;
        this.integrityCaseRepository = integrityCaseRepository;
    }

    @Override
    public EvidenceRecord submitEvidence(EvidenceRecord evidenceRecord) {

        Long caseId = evidenceRecord.getIntegrityCase().getId();

        IntegrityCase integrityCase =
                integrityCaseRepository.findById(caseId)
                        .orElseThrow(() -> new IllegalArgumentException("case not found"));

        evidenceRecord.setIntegrityCase(integrityCase);
        return evidenceRecordRepository.save(evidenceRecord);
    }
}
