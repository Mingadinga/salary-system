package com.hexagonal.salarysystem;

import com.hexagonal.salarysystem.adapter.in.console.CalculateSalaryController;
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SalarySystemApplication {

    private final CalculateSalaryController calculateSalaryController;

    public SalarySystemApplication(CalculateSalaryController calculateSalaryController) {
        this.calculateSalaryController = calculateSalaryController;
    }

    public static void main(String[] args) throws IOException {
        SpringApplication.run(SalarySystemApplication.class, args).getBean(SalarySystemApplication.class).init();
    }

    public void init() throws IOException {
        calculateSalaryController.calculateSalary();
    }

}
