package com.example.demo.service.impl;

import com.example.demo.entity.EvidenceRecord;
import com.example.demo.repository.EvidenceRecordRepository;
import com.example.demo.service.EvidenceRecordService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EvidenceRecordServiceImpl implements EvidenceRecordService {

    private final EvidenceRecordRepository evidenceRecordRepository;

    public EvidenceRecordServiceImpl(EvidenceRecordRepository evidenceRecordRepository) {
        this.evidenceRecordRepository = evidenceRecordRepository;
    }

    @Override
    public EvidenceRecord submitEvidence(EvidenceRecord evidenceRecord) {
        return evidenceRecordRepository.save(evidenceRecord);
    }

    @Override
    public List<EvidenceRecord> getAllEvidence() {
        return evidenceRecordRepository.findAll();
    }
}
