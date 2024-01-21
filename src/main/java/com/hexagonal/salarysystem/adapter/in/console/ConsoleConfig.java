package com.hexagonal.salarysystem.adapter.in.console;

import com.hexagonal.salarysystem.application.port.in.CalculateSalarySumUseCase;
import com.hexagonal.salarysystem.application.port.in.CalculateSalaryUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsoleConfig {

    private final CalculateSalaryUseCase calculateSalaryUseCase;
    private final CalculateSalarySumUseCase calculateSalarySumUseCase;

    public ConsoleConfig(CalculateSalaryUseCase calculateSalaryUseCase,
                         CalculateSalarySumUseCase calculateSalarySumUseCase) {
        this.calculateSalaryUseCase = calculateSalaryUseCase;
        this.calculateSalarySumUseCase = calculateSalarySumUseCase;
    }

    @Bean
    public CalculateSalaryController calculateSalaryController() {
        return new CalculateSalaryController(calculateSalaryUseCase);
    }

    @Bean
    public CalculateSalarySumController calculateSalarySumController() {
        return new CalculateSalarySumController(calculateSalarySumUseCase);
    }
}
