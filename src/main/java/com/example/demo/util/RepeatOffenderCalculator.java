package com.example.demo.util;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;

import java.time.LocalDate;
import java.util.List;

public class RepeatOffenderCalculator {

    public RepeatOffenderCalculator() {
    }

    /**
     * Computes the repeat offender record for a student profile based on their integrity cases.
     *
     * @param studentProfile the student profile
     * @param cases          list of integrity cases associated with the student
     * @return RepeatOffenderRecord with totalCases, severity, and firstIncidentDate set
     */
    public RepeatOffenderRecord computeRepeatOffenderRecord(
            StudentProfile studentProfile,
            List<IntegrityCase> cases) {

        int totalCases = (cases == null) ? 0 : cases.size();

        // Determine severity
        String severity;
        if (totalCases == 1) {
            severity = "LOW";
        } else if (totalCases == 2) {
            severity = "MEDIUM";
        } else if (totalCases >= 4) {
            severity = "HIGH";
        } else {
            severity = "LOW";
        }

        // Compute first incident date
        LocalDate firstIncidentDate = null;
        if (cases != null && !cases.isEmpty()) {
            firstIncidentDate = cases.stream()
                    .map(IntegrityCase::getIncidentDate)
                    .filter(d -> d != null)
                    .min(LocalDate::compareTo)
                    .orElse(null);
        }

        // Update student profile repeat flag
        studentProfile.setRepeatOffender(totalCases >= 2);

        // Create RepeatOffenderRecord
        RepeatOffenderRecord record = new RepeatOffenderRecord();
        record.setStudentProfile(studentProfile);
        record.setTotalCases(totalCases);
        record.setFlagSeverity(severity);
        record.setFirstIncidentDate(firstIncidentDate);

        return record;
    }
}
