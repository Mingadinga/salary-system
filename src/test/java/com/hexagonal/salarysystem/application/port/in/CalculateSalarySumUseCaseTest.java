package com.hexagonal.salarysystem.application.port.in;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hexagonal.salarysystem.application.CalculateSalaryService;
import com.hexagonal.salarysystem.application.port.out.EmployeeInfo;
import com.hexagonal.salarysystem.application.port.out.LoadEmployeeInfoPort;
import com.hexagonal.salarysystem.domain.Money;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculateSalarySumUseCaseTest {
    private LoadEmployeeInfoPort loadEmployeeInfoPort;
    private CalculateSalarySumUseCase useCase;

    @BeforeEach
    void setUp() {
        loadEmployeeInfoPort = mock(LoadEmployeeInfoPort.class);
        useCase = new CalculateSalaryService(loadEmployeeInfoPort);
    }

    @Test
    void testCalculateSalarySum() {
        // 가짜 데이터 생성
        EmployeeInfo fullTimeEmployee1 = new EmployeeInfo(1L, "FullTime1", "FullTime", 0, 0, 50000);
        EmployeeInfo fullTimeEmployee2 = new EmployeeInfo(2L, "FullTime2", "FullTime", 0, 0, 60000);

        List<EmployeeInfo> onlyFullTimeEmployeeList = Arrays.asList(fullTimeEmployee1, fullTimeEmployee2);

        // 모킹 설정
        when(loadEmployeeInfoPort.loadAllByCondition(any())).thenReturn(onlyFullTimeEmployeeList);

        // 테스트 수행
        CalculateSalarySumResult result = useCase.calculateSalarySum();

        // 예상 결과 생성
        int expectedEmployeeCount = onlyFullTimeEmployeeList.size();
        Money expectedSum = new Money(50000 + 60000);

        System.out.println(result.getSum().getValue().toPlainString());

        // 결과 검증
        assertEquals(expectedEmployeeCount, result.getCountOfEmployees(), "직원 수가 일치하지 않습니다.");
        assertEquals(expectedSum, result.getSum(), "총 급여가 일치하지 않습니다.");

        // loadAllByCondition 메소드가 1번 호출되었는지 검증
        verify(loadEmployeeInfoPort, times(1)).loadAllByCondition(any());
    }
}
