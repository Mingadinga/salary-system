package com.hexagonal.salarysystem.application.port.out;

public interface LoadEmployeeInfoPort {
    EmployeeInfo loadOrElseThrow(long employeeId);
}
