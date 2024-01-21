package com.hexagonal.salarysystem.application.port.out;

import com.hexagonal.salarysystem.domain.Employee;
import com.hexagonal.salarysystem.domain.FullTimeEmployee;
import com.hexagonal.salarysystem.domain.Money;
import com.hexagonal.salarysystem.domain.PartTimeEmployee;
import com.hexagonal.salarysystem.domain.WorkDuration;

public class EmployeeFactory {
    public static Employee create(EmployeeInfo employeeInfo, double taxRate) {
        if (employeeInfo.getType().equals("FullTime")) {
            return new FullTimeEmployee(
                    employeeInfo.getId(),
                    employeeInfo.getName(),
                    taxRate,
                    new Money(employeeInfo.getBasePay()));
        }
        else if (employeeInfo.getType().equals("PartTime")) {
            return new PartTimeEmployee(
                    employeeInfo.getId(),
                    employeeInfo.getName(),
                    taxRate,
                    new WorkDuration(employeeInfo.getWorkHour()),
                    new Money(employeeInfo.getPayPerHour()));
        } else {
            throw new IllegalArgumentException("존재하지 않는 직원 유형입니다. 현재값 : " + employeeInfo.getType());
        }
    }
}
