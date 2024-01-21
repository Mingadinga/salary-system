package com.hexagonal.salarysystem.application;

import com.hexagonal.salarysystem.application.port.in.CalculateSalaryCommand;
import com.hexagonal.salarysystem.application.port.in.CalculateSalaryResult;
import com.hexagonal.salarysystem.application.port.in.CalculateSalarySumResult;
import com.hexagonal.salarysystem.application.port.in.CalculateSalarySumUseCase;
import com.hexagonal.salarysystem.application.port.in.CalculateSalaryUseCase;
import com.hexagonal.salarysystem.application.port.out.EmployeeFactory;
import com.hexagonal.salarysystem.application.port.out.EmployeeInfo;
import com.hexagonal.salarysystem.application.port.out.EmployeeSearchCondition;
import com.hexagonal.salarysystem.application.port.out.LoadEmployeeInfoPort;
import com.hexagonal.salarysystem.domain.Employee;
import com.hexagonal.salarysystem.domain.Money;
import java.util.List;

public class CalculateSalaryService implements CalculateSalaryUseCase, CalculateSalarySumUseCase {

    private final LoadEmployeeInfoPort loadEmployeeInfoPort;

    public CalculateSalaryService(LoadEmployeeInfoPort loadEmployeeInfoPort) {
        this.loadEmployeeInfoPort = loadEmployeeInfoPort;
    }

    @Override
    public CalculateSalaryResult calculateSalary(CalculateSalaryCommand command) {
        EmployeeInfo employeeInfo = loadEmployeeInfoPort.loadOrElseThrow(command.getEmployeeId());
        Employee employee = EmployeeFactory.create(employeeInfo, command.getRatio());
        return new CalculateSalaryResult(employee.getName(), employee.calculateSalary());
    }

    @Override
    public CalculateSalarySumResult calculateSalarySum() {
        List<EmployeeInfo> satisfyingEmployeeInfoList = loadEmployeeInfoPort.loadAllByCondition(new EmployeeSearchCondition("FullTime"));
        List<Employee> employeeList = satisfyingEmployeeInfoList.stream().map(EmployeeFactory::create).toList();
        Money sum = employeeList.stream().map(Employee::calculateSalary).reduce(Money::add).orElse(new Money(0));
        return new CalculateSalarySumResult(employeeList.size(), sum);
    }
}
