package com.hexagonal.salarysystem.adapter.in.console;

import com.hexagonal.salarysystem.application.port.in.CalculateSalaryUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsoleConfig {

    private final CalculateSalaryUseCase calculateSalaryUseCase;

    public ConsoleConfig(CalculateSalaryUseCase calculateSalaryUseCase) {
        this.calculateSalaryUseCase = calculateSalaryUseCase;
    }

    @Bean
    public CalculateSalaryController calculateSalaryController() {
        return new CalculateSalaryController(calculateSalaryUseCase);
    }
}
