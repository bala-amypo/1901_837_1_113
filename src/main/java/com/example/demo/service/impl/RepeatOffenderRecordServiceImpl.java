package com.example.demo.service.impl;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.RepeatOffenderRecordRepository;
import com.example.demo.service.RepeatOffenderRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepeatOffenderRecordServiceImpl
        implements RepeatOffenderRecordService {

    private final RepeatOffenderRecordRepository repeatOffenderRecordRepository;

    public RepeatOffenderRecordServiceImpl(
            RepeatOffenderRecordRepository repeatOffenderRecordRepository) {
        this.repeatOffenderRecordRepository = repeatOffenderRecordRepository;
    }

    @Override
    public RepeatOffenderRecord createRecord(RepeatOffenderRecord record) {
        return repeatOffenderRecordRepository.save(record);
    }

    @Override
    public List<RepeatOffenderRecord> getAll() {
        return repeatOffenderRecordRepository.findAll();
    }

    @Override
    public List<RepeatOffenderRecord> getByStudentProfile(StudentProfile studentProfile) {
        // ✅ Now repository returns List — NO Optional
        return repeatOffenderRecordRepository.findByStudentProfile(studentProfile);
    }
}
