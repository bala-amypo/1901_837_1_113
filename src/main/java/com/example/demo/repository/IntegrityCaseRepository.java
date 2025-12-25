package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IntegrityCaseRepository
        extends JpaRepository<IntegrityCase, Long> {

    List<IntegrityCase> findByStudentProfile(StudentProfile s);

    List<IntegrityCase> findByStudentProfile_Id(Long id);

    List<IntegrityCase> findByStudentIdentifier(String sid);

    List<IntegrityCase> findRecentCasesByStatus(String status, LocalDate date);

    List<IntegrityCase> findByIncidentDateBetween(LocalDate a, LocalDate b);

    List<IntegrityCase> findByStatus(String status);
}
