package com.hexagonal.salarysystem.application.port.in;

import com.hexagonal.salarysystem.domain.Money;

public class CalculateSalaryResult {
    String name;
    Money money;

    public CalculateSalaryResult(String name, Money money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public Money getMoney() {
        return money;
    }

}
