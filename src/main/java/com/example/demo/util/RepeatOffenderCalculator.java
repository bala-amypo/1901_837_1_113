package com.example.demo.util;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.entity.IntegrityCase;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class RepeatOffenderCalculator {

    public RepeatOffenderRecord computeRepeatOffenderRecord(StudentProfile student, List<IntegrityCase> cases) {
        RepeatOffenderRecord record = new RepeatOffenderRecord();
        record.setStudentProfile(student);
        record.setTotalCases(cases.size());

        if (cases.size() == 1) record.setFlagSeverity("LOW");
        else if (cases.size() == 2) record.setFlagSeverity("MEDIUM");
        else if (cases.size() >= 4) record.setFlagSeverity("HIGH");

        return record;
    }
}
