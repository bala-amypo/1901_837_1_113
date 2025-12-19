package com.example.demo.service.impl;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.RepeatOffenderRecordRepository;
import com.example.demo.service.RepeatOffenderRecordService;
import com.example.demo.util.RepeatOffenderCalculator;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RepeatOffenderRecordServiceImpl implements RepeatOffenderRecordService {

    private final StudentProfileRepository studentRepo;
    private final IntegrityCaseRepository caseRepo;
    private final RepeatOffenderRecordRepository repeatRepo;
    private final RepeatOffenderCalculator calculator;

    public RepeatOffenderRecordServiceImpl(StudentProfileRepository studentRepo,
                                           IntegrityCaseRepository caseRepo,
                                           RepeatOffenderRecordRepository repeatRepo,
                                           RepeatOffenderCalculator calculator) {
        this.studentRepo = studentRepo;
        this.caseRepo = caseRepo;
        this.repeatRepo = repeatRepo;
        this.calculator = calculator;
    }

    @Override
    public RepeatOffenderRecord recalculateAndGet(Long studentId) {
        StudentProfile student = studentRepo.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("StudentProfile not found"));

        List<?> cases = caseRepo.findByStudentProfile_Id(studentId);
        RepeatOffenderRecord record = calculator.computeRepeatOffenderRecord(student, (List) cases);

        repeatRepo.save(record);
        student.setRepeatOffender(cases.size() >= 2);
        studentRepo.save(student);

        return record;
    }
}
