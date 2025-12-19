package com.example.demo.service.impl;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.StudentProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.IntegrityCaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IntegrityCaseServiceImpl implements IntegrityCaseService {

    private final IntegrityCaseRepository caseRepo;
    private final StudentProfileRepository studentRepo;

    public IntegrityCaseServiceImpl(IntegrityCaseRepository caseRepo,
                                    StudentProfileRepository studentRepo) {
        this.caseRepo = caseRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public IntegrityCase createCase(IntegrityCase integrityCase) {
        Long studentId = integrityCase.getStudentProfile().getId();
        StudentProfile student = studentRepo.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("StudentProfile not found"));
        integrityCase.setStatus("OPEN");
        integrityCase.setStudentProfile(student);
        return caseRepo.save(integrityCase);
    }

    @Override
    public IntegrityCase updateCaseStatus(Long caseId, String newStatus) {
        IntegrityCase ic = caseRepo.findById(caseId)
                .orElseThrow(() -> new ResourceNotFoundException("IntegrityCase not found"));
        ic.setStatus(newStatus);
        return caseRepo.save(ic);
    }

    @Override
    public List<IntegrityCase> getCasesByStudent(Long studentId) {
        return caseRepo.findByStudentProfile_Id(studentId);
    }

    @Override
    public Optional<IntegrityCase> getCaseById(Long caseId) {
        return caseRepo.findById(caseId);
    }
}
