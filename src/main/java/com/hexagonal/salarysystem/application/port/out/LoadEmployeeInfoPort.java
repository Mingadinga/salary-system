package com.hexagonal.salarysystem.application.port.out;

import com.hexagonal.salarysystem.domain.Employee;

public interface LoadEmployeeInfoPort {
    EmployeeInfo loadOrElseThrow(long employeeId) throws IllegalStateException;
}
