package com.example.demo.util;

import com.example.demo.entity.IntegrityCase;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class RepeatOffenderCalculator {
    
    public String calculateSeverity(int totalCases) {
        if (totalCases == 1) return "LOW";
        if (totalCases == 2) return "MEDIUM";
        if (totalCases >= 4) return "HIGH";
        return "LOW";
    }
    
    public boolean isRepeatOffender(List<IntegrityCase> cases) {
        return cases.size() >= 2;
    }
}
