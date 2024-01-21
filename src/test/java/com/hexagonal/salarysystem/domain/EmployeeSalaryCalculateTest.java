package com.hexagonal.salarysystem.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class EmployeeSalaryCalculateTest {

    @Test
    void testCalculateSalaryForEmployeeList() {
        // Employee 리스트 생성
        List<Employee> employees = new ArrayList<>();
        employees.add(new FullTimeEmployee(0.15, new Money(50000)));
        employees.add(new PartTimeEmployee(0.2, new WorkDuration(10), new Money(15)));

        // Employee 리스트의 각 객체의 calculateSalary() 결과와 기대값이 일치하는지 확인
        Money expectedFullTimeSalary = new Money(42500); // 50000 * (1 - 0.15) = 42500
        assertEquals(expectedFullTimeSalary, employees.get(0).calculateSalary(), "FullTimeEmployee의 급여 계산이 올바르지 않습니다.");

        Money expectedPartTimeSalary = new Money(120); // 15 * 10 * (1 - 0.2) = 120
        assertEquals(expectedPartTimeSalary, employees.get(1).calculateSalary(), "PartTimeEmployee의 급여 계산이 올바르지 않습니다.");
    }

}