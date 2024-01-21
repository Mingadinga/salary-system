package com.hexagonal.salarysystem.adapter.out.persistence;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hexagonal.salarysystem.adapter.out.persistence.java.map.EmployeeInfoMapEntity;
import com.hexagonal.salarysystem.application.port.out.EmployeeInfo;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class EmployeePersistenceAdapterWithJavaMapRepositoryTest {
    @Test
    void testLoadOrElseThrow_ExistingEmployeeId_ReturnsEmployeeInfo() {
        // 테스트용 직원 정보 맵 생성
        Map<Long, EmployeeInfoMapEntity> employeeMap = new HashMap<>();
        EmployeeInfoMapEntity johnDoeInfo = new EmployeeInfoMapEntity(1L, "John Doe", "FullTime", 0, 0, 50000);
        employeeMap.put(johnDoeInfo.getId(), johnDoeInfo);

        // Mock EmployeeRepository 생성
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        when(employeeRepository.findEmployeeInfoById(1L)).thenReturn(Optional.of(johnDoeInfo));

        // 테스트할 클래스 생성
        EmployeePersistenceAdapter employeeAdapter = new EmployeePersistenceAdapter(employeeRepository);

        // 테스트 수행
        EmployeeInfo result = employeeAdapter.loadOrElseThrow(1L);

        // 결과 검증
        assertNotNull(result);
        assertEquals(johnDoeInfo.getId(), result.getId());
        assertEquals(johnDoeInfo.getName(), result.getName());

        // findEmployeeInfoById 메소드가 1번 호출되었는지 검증
        verify(employeeRepository, times(1)).findEmployeeInfoById(1L);
    }

    @Test
    void testLoadOrElseThrow_NonExistingEmployeeId_ThrowsIllegalStateException() {
        // Mock EmployeeRepository 생성
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        when(employeeRepository.findEmployeeInfoById(2L)).thenReturn(Optional.empty());

        // 테스트할 클래스 생성
        EmployeePersistenceAdapter employeeAdapter = new EmployeePersistenceAdapter(employeeRepository);

        // 테스트 수행 및 예외 검증
        assertThrows(IllegalStateException.class, () -> employeeAdapter.loadOrElseThrow(2L));

        // findEmployeeInfoById 메소드가 1번 호출되었는지 검증
        verify(employeeRepository, times(1)).findEmployeeInfoById(2L);
    }

}