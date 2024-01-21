package com.hexagonal.salarysystem.application.port.in;

import java.math.BigDecimal;

public class CalculateSalaryCommand {
    private long employeeId;
    private BigDecimal percent;

    public CalculateSalaryCommand(long employeeId, double percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("퍼센트 값은 0 이상 100 이하이어야 합니다. 현재 값 : " + percent);
        }
        this.percent = BigDecimal.valueOf(percent);
        this.employeeId = employeeId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public double getRatio() {
        return percent.divide(BigDecimal.valueOf(100)).doubleValue();
    }
}
