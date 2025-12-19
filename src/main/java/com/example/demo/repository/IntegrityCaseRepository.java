package com.example.demo.repository;

import com.example.demo.entity.IntegrityCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IntegrityCaseRepository extends JpaRepository<IntegrityCase, Long> {

    List<IntegrityCase> findByStudentProfile_Id(Long studentId);

    List<IntegrityCase> findByStudentProfile_StudentId(String studentIdentifier);

    List<IntegrityCase> findByStatus(String status);

    List<IntegrityCase> findByIncidentDateBetween(LocalDate start, LocalDate end);

    List<IntegrityCase> findByStatusAndIncidentDateAfter(String status, LocalDate sinceDate);

}
