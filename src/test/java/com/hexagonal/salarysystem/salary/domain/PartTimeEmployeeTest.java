package com.hexagonal.salarysystem.salary.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PartTimeEmployeeTest {

    @Test
    void testCalculateSalaryWithSuccess() {
        double taxRate = 0.1;
        int workTime = 20;
        Money basePayOfTime = new Money(18);

        Employee employee = new PartTimeEmployee(taxRate, new WorkDuration(workTime), basePayOfTime);

        Money expectedSalary = new Money(324); // 18 * 20 * (1 - 0.1) = 324
        assertEquals(expectedSalary, employee.calculateSalary(), "급여 계산이 올바르지 않습니다.");
    }

}