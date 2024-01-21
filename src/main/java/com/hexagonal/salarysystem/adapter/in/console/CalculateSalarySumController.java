package com.hexagonal.salarysystem.adapter.in.console;

import com.hexagonal.salarysystem.application.port.in.CalculateSalarySumResult;
import com.hexagonal.salarysystem.application.port.in.CalculateSalarySumUseCase;
import java.io.IOException;

public class CalculateSalarySumController {
    private final CalculateSalarySumUseCase useCase;

    public CalculateSalarySumController(CalculateSalarySumUseCase useCase) {
        this.useCase = useCase;
    }


    public void calculateSalary() throws IOException {
        System.out.println("모든 일반 직원의 급여 총합을 계산하고 있습니다 . . .");

        CalculateSalarySumResult result = useCase.calculateSalarySum();

        System.out.println("일반 직원의 급여 총합 계산 결과");
        System.out.println("인원: " + result.getCountOfEmployees() +
                ", 급여: " + result.getSum().getValue().toPlainString()+"원");
    }
}
