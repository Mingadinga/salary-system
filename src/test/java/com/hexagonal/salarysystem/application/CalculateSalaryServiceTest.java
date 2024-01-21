package com.hexagonal.salarysystem.application;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hexagonal.salarysystem.application.port.in.CalculateSalaryCommand;
import com.hexagonal.salarysystem.application.port.out.EmployeeInfo;
import com.hexagonal.salarysystem.application.port.out.LoadEmployeeInfoPort;
import com.hexagonal.salarysystem.domain.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculateSalaryServiceTest {

    private LoadEmployeeInfoPort loadEmployeeInfoPort;
    private CalculateSalaryService calculateSalaryService;

    @BeforeEach
    void setUp() {
        loadEmployeeInfoPort = mock(LoadEmployeeInfoPort.class);
        calculateSalaryService = new CalculateSalaryService(loadEmployeeInfoPort);
    }

    @Test
    void testCalculateSalaryOfFullTime() {
        EmployeeInfo employeeInfo = new EmployeeInfo(1L, "정직원", "FullTime", 0, 0, 50000);
        when(loadEmployeeInfoPort.loadOrElseThrow(1L)).thenReturn(employeeInfo);
        CalculateSalaryCommand command = new CalculateSalaryCommand(1, 15);

        Money result = calculateSalaryService.calculateSalary(command).getMoney();

        Money expected = new Money(42500); // 50000 * (1 - 0.15) = 42500
        assertEquals(expected, result, "최종 결과가 기대한 값과 다릅니다.");
    }

    @Test
    void testCalculateSalaryOfPartTime() {
        EmployeeInfo employeeInfo = new EmployeeInfo(1L, "아르바이트생", "PartTime", 10, 15, 0);
        when(loadEmployeeInfoPort.loadOrElseThrow(1L)).thenReturn(employeeInfo);
        CalculateSalaryCommand command = new CalculateSalaryCommand(1, 20);

        Money result = calculateSalaryService.calculateSalary(command).getMoney();

        Money expected = new Money(120); // 15 * 10 * (1 - 0.2) = 120
        assertEquals(expected, result, "최종 결과가 기대한 값과 다릅니다.");
    }


}