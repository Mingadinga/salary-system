package com.hexagonal.salarysystem.application;

import com.hexagonal.salarysystem.application.port.in.CalculateSalaryCommand;
import com.hexagonal.salarysystem.application.port.in.CalculateSalaryUseCase;
import com.hexagonal.salarysystem.application.port.out.EmployeeFactory;
import com.hexagonal.salarysystem.application.port.out.EmployeeInfo;
import com.hexagonal.salarysystem.application.port.out.LoadEmployeeInfoPort;
import com.hexagonal.salarysystem.domain.Employee;
import com.hexagonal.salarysystem.domain.Money;

public class CalculateSalaryService implements CalculateSalaryUseCase {

    private final LoadEmployeeInfoPort loadEmployeeInfoPort;

    public CalculateSalaryService(LoadEmployeeInfoPort loadEmployeeInfoPort) {
        this.loadEmployeeInfoPort = loadEmployeeInfoPort;
    }

    @Override
    public Money calculateSalary(CalculateSalaryCommand command) {
        EmployeeInfo employeeInfo = loadEmployeeInfoPort.loadOrElseThrow(command.getEmployeeId());
        Employee employee = EmployeeFactory.create(employeeInfo, command.getRatio());
        return employee.calculateSalary();
    }
}
