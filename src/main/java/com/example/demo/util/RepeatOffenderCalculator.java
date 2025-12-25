package com.example.demo.util;

import com.example.demo.entity.*;
import java.util.List;

public class RepeatOffenderCalculator {

    public RepeatOffenderRecord computeRepeatOffenderRecord(
            StudentProfile student, List<IntegrityCase> cases) {

        int count = cases.size();
        String severity = count >= 4 ? "HIGH" : count >= 2 ? "MEDIUM" : "LOW";

        RepeatOffenderRecord r = new RepeatOffenderRecord();
        r.setStudentProfile(student);
        r.setTotalCases(count);
        r.setFlagSeverity(severity);
        return r;
    }
}
