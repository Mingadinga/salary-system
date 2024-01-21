package com.hexagonal.salarysystem.domain;

public class FullTimeEmployee extends Employee {

    private double taxRate;
    private Money basePay;

    public FullTimeEmployee(Long id, String name, double taxRate, Money basePay) {
        this.id = id;
        this.name = name;
        this.taxRate = taxRate;
        this.basePay = basePay;
    }

    @Override
    public Money calculateSalary() {
        return basePay.multiply(1 - taxRate);
    }
}
