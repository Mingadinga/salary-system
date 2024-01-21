package com.hexagonal.salarysystem.adapter.in.console;

import com.hexagonal.salarysystem.adapter.in.StartingPoint;
import com.hexagonal.salarysystem.application.port.in.CalculateSalarySumUseCase;
import com.hexagonal.salarysystem.application.port.in.CalculateSalaryUseCase;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsoleConfig {

    private final CalculateSalaryUseCase calculateSalaryUseCase;
    private final CalculateSalarySumUseCase calculateSalarySumUseCase;

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public ConsoleConfig(CalculateSalaryUseCase calculateSalaryUseCase,
                         CalculateSalarySumUseCase calculateSalarySumUseCase) {
        this.calculateSalaryUseCase = calculateSalaryUseCase;
        this.calculateSalarySumUseCase = calculateSalarySumUseCase;
    }

    @Bean
    public CalculateSalaryController calculateSalaryController() {
        return new CalculateSalaryController(calculateSalaryUseCase, br);
    }

    @Bean
    public CalculateSalarySumController calculateSalarySumController() {
        return new CalculateSalarySumController(calculateSalarySumUseCase);
    }

    @Bean
    public StartingPoint startingPoint() {
        return new StartingPointOnConsole(calculateSalaryController(), calculateSalarySumController(), br);
    }
}
