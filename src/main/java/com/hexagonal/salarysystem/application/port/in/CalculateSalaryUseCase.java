package com.hexagonal.salarysystem.application.port.in;

import com.hexagonal.salarysystem.domain.Money;

public interface CalculateSalaryUseCase {
    CalculateSalaryResult calculateSalary(CalculateSalaryCommand command);
}
