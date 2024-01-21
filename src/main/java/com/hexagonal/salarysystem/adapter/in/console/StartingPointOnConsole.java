package com.hexagonal.salarysystem.adapter.in.console;

import com.hexagonal.salarysystem.adapter.in.StartingPoint;
import java.io.BufferedReader;
import java.io.IOException;

public class StartingPointOnConsole implements StartingPoint {

    private final CalculateSalaryController salaryController;
    private final CalculateSalarySumController salarySumController;
    private final BufferedReader br;

    public StartingPointOnConsole(CalculateSalaryController salaryController,
                                  CalculateSalarySumController salarySumController, BufferedReader br) {
        this.salaryController = salaryController;
        this.salarySumController = salarySumController;
        this.br = br;
    }

    @Override
    public void start() {

        while (true) {
            System.out.println("급여 계산 시스템");
            System.out.println();
            System.out.println("실행할 기능을 선택하세요");
            System.out.println("1. 급여 계산");
            System.out.println("2. 모든 일반 직원의 급여 총합 계산");
            System.out.println("3. 중단하기");
            System.out.println();
            System.out.print("실행할 기능 입력(숫자로) : ");

            try {
                int choice = Integer.parseInt(br.readLine());
                if (choice == 1)
                    salaryController.calculateSalary();
                else if (choice == 2)
                    salarySumController.calculateSalary();
                else if (choice == 3) break;
                else
                    throw new IllegalArgumentException("유효한 기능 번호를 선택하세요(1~2). 입력한 번호 : " + choice);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
