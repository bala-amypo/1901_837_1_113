package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.IntegrityCaseService;

import java.util.List;
import java.util.Optional;

public class IntegrityCaseServiceImpl implements IntegrityCaseService {

    private final IntegrityCaseRepository caseRepo;
    private final StudentProfileRepository studentRepo;

    public IntegrityCaseServiceImpl(
            IntegrityCaseRepository caseRepo,
            StudentProfileRepository studentRepo) {
        this.caseRepo = caseRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public IntegrityCase createCase(IntegrityCase c) {
        if (c.getStudentProfile() == null || c.getStudentProfile().getId() == null)
            throw new IllegalArgumentException("Student required");

        StudentProfile s = studentRepo.findById(c.getStudentProfile().getId())
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));

        c.setStudentProfile(s);
        c.setStatus("OPEN");
        return caseRepo.save(c);
    }

    @Override
    public IntegrityCase updateCaseStatus(Long id, String status) {
        IntegrityCase c = caseRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Case not found"));
        c.setStatus(status);
        return caseRepo.save(c);
    }

    @Override
    public List<IntegrityCase> getCasesByStudent(Long studentId) {
        return caseRepo.findByStudentProfile_Id(studentId);
    }

    @Override
    public Optional<IntegrityCase> getCaseById(Long id) {
        return caseRepo.findById(id);
    }
}
