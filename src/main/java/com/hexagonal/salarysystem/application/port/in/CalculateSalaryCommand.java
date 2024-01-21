package com.hexagonal.salarysystem.application.port.in;

public class CalculateSalaryCommand {
    private long employeeId;
    private Percent percent;

    public CalculateSalaryCommand(long employeeId, double percent) {
        this.employeeId = employeeId;
        this.percent = new Percent(percent);
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public double getRatio() {
        return percent.toRatio();
    }
}
