package com.hexagonal.salarysystem.adapter.in.console;

import com.hexagonal.salarysystem.application.port.in.CalculateSalaryCommand;
import com.hexagonal.salarysystem.application.port.in.CalculateSalaryResult;
import com.hexagonal.salarysystem.application.port.in.CalculateSalaryUseCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculateSalaryController {

    private final CalculateSalaryUseCase calculateSalaryUseCase;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public CalculateSalaryController(CalculateSalaryUseCase calculateSalaryUseCase) {
        this.calculateSalaryUseCase = calculateSalaryUseCase;
    }

    public void calculateSalary() throws IOException {
        System.out.print("직원의 아이디를 입력하세요 : ");
        long employeeId = Long.parseLong(br.readLine());

        System.out.print("소득세율을 입력하세요(% 단위) : ");
        double percent = Double.parseDouble(br.readLine());

        CalculateSalaryCommand command = new CalculateSalaryCommand(employeeId, percent);
        CalculateSalaryResult result = calculateSalaryUseCase.calculateSalary(command);

        System.out.println("급여 계산 결과");
        System.out.println("이름: " + result.getName() +
                ", 급여: " + result.getMoney().getValue().toPlainString()+"원");

    }
}
