package com.hexagonal.salarysystem.application.port.out;

import static org.junit.jupiter.api.Assertions.*;

import com.hexagonal.salarysystem.domain.Employee;
import com.hexagonal.salarysystem.domain.Money;
import org.junit.jupiter.api.Test;

class EmployeeFactoryTest {

    @Test
    void testCalculateSalaryForFullTimeEmployee() {
        EmployeeInfo employeeInfo = new EmployeeInfo(1L, "정직원", "FullTime", 0, 0, 50000);
        double taxRate = 0.15;

        Employee employee = EmployeeFactory.create(employeeInfo, taxRate);

        Money expectedFullTimeSalary = new Money(42500); // 50000 * (1 - 0.15) = 42500
        assertEquals(expectedFullTimeSalary, employee.calculateSalary(), "FullTimeEmployee의 급여 계산이 올바르지 않습니다.");
    }

    @Test
    void testCalculateSalaryForPartTimeEmployee() {
        EmployeeInfo employeeInfo = new EmployeeInfo(1L, "아르바이트생", "PartTime", 10, 15, 0);
        double taxRate = 0.2;

        Employee employee = EmployeeFactory.create(employeeInfo, taxRate);

        Money expectedPartTimeSalary = new Money(120); // 15 * 10 * (1 - 0.2) = 120
        assertEquals(expectedPartTimeSalary, employee.calculateSalary(), "PartTimeEmployee의 급여 계산이 올바르지 않습니다.");
    }


}