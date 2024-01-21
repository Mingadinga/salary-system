package com.hexagonal.salarysystem.salary.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FullTimeEmployeeTest {

    @Test
    void testCalculateSalary() {
        double taxRate = 0.15;
        Money basePay = new Money(50000);

        FullTimeEmployee employee = new FullTimeEmployee(taxRate, basePay);

        Money expectedSalary = new Money(42500); // 50000 * (1 - 0.15) = 42500
        assertEquals(expectedSalary, employee.calculateSalary(), "급여 계산이 올바르지 않습니다.");
    }

}