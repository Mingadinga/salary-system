package com.hexagonal.salarysystem.adapter.out.persistence;

import static org.junit.jupiter.api.Assertions.*;

import com.hexagonal.salarysystem.adapter.out.persistence.java.map.EmployeeInfoMapEntity;
import com.hexagonal.salarysystem.adapter.out.persistence.java.map.EmployeeRepositoryJavaMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class EmployeeRepositoryJavaMapTest {

    @Test
    void testFindEmployeeInfoById_ExistingId_ReturnsEmployeeInfo() {
        Map<Long, EmployeeInfoMapEntity> employeeMap = new HashMap<>();
        EmployeeInfoMapEntity johnDoeInfo = new EmployeeInfoMapEntity(1L, "정직원", "FullTime", 0, 0, 50000);
        employeeMap.put(johnDoeInfo.getId(), johnDoeInfo);

        EmployeeRepositoryJavaMap employeeRepository = new EmployeeRepositoryJavaMap(employeeMap);

        // 테스트 수행
        Optional<ConvertableToEmployeeInfo> result = employeeRepository.findEmployeeInfoById(1L);

        // 결과 검증
        assertTrue(result.isPresent());
        assertEquals(johnDoeInfo, result.get(), "직원 정보가 올바르게 반환되어야 합니다.");
    }

    @Test
    void testFindEmployeeInfoById_NonExistingId_ReturnsEmptyOptional() {
        Map<Long, EmployeeInfoMapEntity> employeeMap = new HashMap<>();
        EmployeeRepositoryJavaMap employeeRepository = new EmployeeRepositoryJavaMap(employeeMap);

        // 테스트 수행
        Optional<ConvertableToEmployeeInfo> result = employeeRepository.findEmployeeInfoById(2L);

        // 결과 검증
        assertTrue(result.isEmpty(), "존재하지 않는 ID에 대한 조회는 빈 Optional을 반환해야 합니다.");
    }
}
