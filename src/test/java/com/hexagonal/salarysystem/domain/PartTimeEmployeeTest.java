package com.hexagonal.salarysystem.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PartTimeEmployeeTest {

    @Test
    void testCalculateSalaryWithSuccess() {
        double taxRate = 0.1;
        int workHour = 20, workMinute = 10;
        Money basePayOfTime = new Money(18);

        Employee employee = new PartTimeEmployee(1L, "아르바이트생", taxRate, new WorkDuration(workHour, workMinute), basePayOfTime);

        Money expectedSalary = new Money(324); // 18 * 20 * (1 - 0.1) = 324
        assertEquals(expectedSalary, employee.calculateSalary(), "급여 계산이 올바르지 않습니다.");
    }

}