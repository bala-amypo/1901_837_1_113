package com.example.demo.util;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component   // ✅ Make this a Spring bean
public class RepeatOffenderCalculator {

    public RepeatOffenderRecord computeRepeatOffenderRecord(
            StudentProfile student, List<IntegrityCase> cases) {

        RepeatOffenderRecord record = new RepeatOffenderRecord();
        record.setStudentProfile(student);
        record.setTotalCases(cases.size());

        // Severity logic
        if (cases.size() >= 4) {
            record.setFlagSeverity("HIGH");
        } else if (cases.size() == 2 || cases.size() == 3) {
            record.setFlagSeverity("MEDIUM");
        } else {
            record.setFlagSeverity("LOW");
        }

        return record;
    }
}
