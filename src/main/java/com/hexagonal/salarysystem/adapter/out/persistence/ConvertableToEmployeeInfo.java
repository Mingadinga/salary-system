package com.hexagonal.salarysystem.adapter.out.persistence;

import com.hexagonal.salarysystem.application.port.out.EmployeeInfo;

public interface ConvertableToEmployeeInfo {
    EmployeeInfo mapToEmployeeInfo();
}
