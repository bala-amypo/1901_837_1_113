package com.example.demo.util;

import com.example.demo.entity.*;
import java.util.List;

public class RepeatOffenderCalculator {

    public RepeatOffenderRecord computeRepeatOffenderRecord(
            StudentProfile student,
            List<IntegrityCase> cases) {

        int total = cases.size();
        String severity = "LOW";

        if (total >= 4) severity = "HIGH";
        else if (total >= 2) severity = "MEDIUM";

        RepeatOffenderRecord record = new RepeatOffenderRecord();
        record.setStudentProfile(student);
        record.setTotalCases(total);
        record.setFlagSeverity(severity);

        return record;
    }
}
