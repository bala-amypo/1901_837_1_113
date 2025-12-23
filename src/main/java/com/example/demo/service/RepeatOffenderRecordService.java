package com.example.demo.service;

import com.example.demo.entity.RepeatOffenderRecord;
import java.util.List;

public interface RepeatOffenderRecordService {
    RepeatOffenderRecord refreshRepeatOffender(Long studentId);
    List<RepeatOffenderRecord> getByStudent(Long studentId);
    List<RepeatOffenderRecord> getAll();
}
