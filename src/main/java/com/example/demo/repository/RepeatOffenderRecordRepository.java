package com.example.demo.repository;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepeatOffenderRecordRepository
        extends JpaRepository<RepeatOffenderRecord, Long> {

    // ✅ MUST be List — NOT Optional
    List<RepeatOffenderRecord> findByStudentProfile(StudentProfile studentProfile);
}
