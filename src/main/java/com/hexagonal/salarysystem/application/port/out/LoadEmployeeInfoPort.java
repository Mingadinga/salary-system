package com.hexagonal.salarysystem.application.port.out;

import java.util.List;

public interface LoadEmployeeInfoPort {
    EmployeeInfo loadOrElseThrow(long employeeId);
    List<EmployeeInfo> loadAllByCondition(EmployeeSearchCondition condition);
}
