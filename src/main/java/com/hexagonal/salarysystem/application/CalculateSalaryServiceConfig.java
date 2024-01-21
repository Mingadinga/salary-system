package com.hexagonal.salarysystem.application;

import com.hexagonal.salarysystem.application.port.in.CalculateSalarySumUseCase;
import com.hexagonal.salarysystem.application.port.in.CalculateSalaryUseCase;
import com.hexagonal.salarysystem.application.port.out.LoadEmployeeInfoPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculateSalaryServiceConfig {
    private final LoadEmployeeInfoPort loadEmployeeInfoPort;

    public CalculateSalaryServiceConfig(LoadEmployeeInfoPort loadEmployeeInfoPort) {
        this.loadEmployeeInfoPort = loadEmployeeInfoPort;
    }

    @Bean
    public CalculateSalaryUseCase calculateSalaryUseCase() {
        return new CalculateSalaryService(loadEmployeeInfoPort);
    }

    @Bean
    public CalculateSalarySumUseCase calculateSalarySumUseCase() {
        return new CalculateSalaryService(loadEmployeeInfoPort);
    }

}
