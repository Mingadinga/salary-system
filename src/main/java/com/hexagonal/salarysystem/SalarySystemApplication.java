package com.hexagonal.salarysystem;

import com.hexagonal.salarysystem.adapter.in.StartingPoint;
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SalarySystemApplication {

    private final StartingPoint startingPoint;

    public SalarySystemApplication(StartingPoint startingPoint) {
        this.startingPoint = startingPoint;
    }

    public static void main(String[] args) throws IOException {
        SpringApplication.run(SalarySystemApplication.class, args).getBean(SalarySystemApplication.class).init();
    }

    public void init() throws IOException {
        startingPoint.start();
    }

}
