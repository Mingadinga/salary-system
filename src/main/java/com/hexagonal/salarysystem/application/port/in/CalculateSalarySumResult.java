package com.hexagonal.salarysystem.application.port.in;

import com.hexagonal.salarysystem.domain.Money;

public class CalculateSalarySumResult {
    private int countOfEmployees;
    private Money sum;

    public CalculateSalarySumResult(int countOfEmployees, Money sum) {
        this.countOfEmployees = countOfEmployees;
        this.sum = sum;
    }

    public int getCountOfEmployees() {
        return countOfEmployees;
    }

    public Money getSum() {
        return sum;
    }
}
