package com.example.demo.service.impl;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.RepeatOffenderRecordRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.RepeatOffenderRecordService;
import com.example.demo.util.RepeatOffenderCalculator;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RepeatOffenderRecordServiceImpl implements RepeatOffenderRecordService {
    private final StudentProfileRepository studentProfileRepository;
    private final IntegrityCaseRepository integrityCaseRepository;
    private final RepeatOffenderRecordRepository repeatOffenderRecordRepository;
    private final RepeatOffenderCalculator repeatOffenderCalculator;
    
    public RepeatOffenderRecordServiceImpl(StudentProfileRepository studentProfileRepository,
                                         IntegrityCaseRepository integrityCaseRepository,
                                         RepeatOffenderRecordRepository repeatOffenderRecordRepository,
                                         RepeatOffenderCalculator repeatOffenderCalculator) {
        this.studentProfileRepository = studentProfileRepository;
        this.integrityCaseRepository = integrityCaseRepository;
        this.repeatOffenderRecordRepository = repeatOffenderRecordRepository;
        this.repeatOffenderCalculator = repeatOffenderCalculator;
    }
    
    @Override
    public RepeatOffenderRecord recalculateRecord(StudentProfile studentProfile) {
        List<IntegrityCase> cases = integrityCaseRepository.findByStudentProfile_Id(studentProfile.getId());
        
        RepeatOffenderRecord record = repeatOffenderRecordRepository.findByStudentProfile(studentProfile)
                .orElse(new RepeatOffenderRecord());
        
        record.setStudentProfile(studentProfile);
        record.setTotalCases(cases.size());
        record.setFlagSeverity(repeatOffenderCalculator.calculateSeverity(cases.size()));
        
        boolean isRepeatOffender = repeatOffenderCalculator.isRepeatOffender(cases);
        studentProfile.setRepeatOffender(isRepeatOffender);
        studentProfileRepository.save(studentProfile);
        
        return repeatOffenderRecordRepository.save(record);
    }
}
