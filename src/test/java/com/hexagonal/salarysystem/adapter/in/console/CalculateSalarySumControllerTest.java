package com.hexagonal.salarysystem.adapter.in.console;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hexagonal.salarysystem.application.port.in.CalculateSalarySumResult;
import com.hexagonal.salarysystem.application.port.in.CalculateSalarySumUseCase;
import com.hexagonal.salarysystem.domain.Money;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculateSalarySumControllerTest {

    private CalculateSalarySumUseCase useCase;
    private CalculateSalarySumController controller;

    @BeforeEach
    void setUp() {
        useCase = mock(CalculateSalarySumUseCase.class);
        controller = new CalculateSalarySumController(useCase);
    }

    @Test
    void testCalculateSalarySumConsole() throws IOException {
        // 사용자 입력을 모킹
        BufferedReader mockBufferedReader = mock(BufferedReader.class);
        when(mockBufferedReader.readLine()).thenReturn("1", "15"); // 아이디, 소득세 퍼센트
        CalculateSalaryController.br = mockBufferedReader;
        when(useCase.calculateSalarySum()).thenReturn(new CalculateSalarySumResult(2, new Money(42500)));

        // 결과를 캡처하기 위한 ByteArrayOutputStream 생성
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // 테스트 수행
        controller.calculateSalary();

        // CalculateSalaryUseCase의 calculateSalary 메서드가 1번 호출되었는지 검증
        verify(useCase, times(1)).calculateSalarySum();

        // 예상 출력 결과 (기본 급여 50000 * (1 - 0.15) = 42500)
        String expectedOutput = "일반 직원의 급여 총합 계산 결과\n인원: 2, 급여: 42500원\n";
        assertTrue(outputStreamCaptor.toString().contains(expectedOutput));
    }
}