package com.hexagonal.salarysystem.domain;

public class PartTimeEmployee extends Employee {
    private double taxRate;
    private WorkDuration workTime;
    private Money basePayOfTime;

    public PartTimeEmployee(Long id, String name, double taxRate, WorkDuration workTime, Money basePayOfTime) {
        this.id = id;
        this.name = name;
        this.taxRate = taxRate;
        this.workTime = workTime;
        this.basePayOfTime = basePayOfTime;
    }

    @Override
    public Money calculateSalary() {
        Money basePay = basePayOfTime.multiply(workTime.toHour());
        return basePay.multiply(1 - taxRate);
    }
}
