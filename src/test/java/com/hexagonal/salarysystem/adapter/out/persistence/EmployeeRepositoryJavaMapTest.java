package com.hexagonal.salarysystem.adapter.out.persistence;

import static org.junit.jupiter.api.Assertions.*;

import com.hexagonal.salarysystem.adapter.out.persistence.java.map.EmployeeInfoMapEntity;
import com.hexagonal.salarysystem.adapter.out.persistence.java.map.EmployeeRepositoryJavaMap;
import com.hexagonal.salarysystem.application.port.out.EmployeeSearchCondition;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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

    @Test
    void testFindAllByCondition_TypeCondition_ReturnsConvertableToEmployeeInfo() {
        Map<Long, EmployeeInfoMapEntity> employeeMap = new HashMap<>();
        EmployeeInfoMapEntity info1 = new EmployeeInfoMapEntity(1L, "정직원", "FullTime", 0, 0, 50000);
        EmployeeInfoMapEntity info2 = new EmployeeInfoMapEntity(2L, "정직원", "FullTime", 0, 0, 50000);
        EmployeeInfoMapEntity info3 = new EmployeeInfoMapEntity(3L, "정직원", "PartTime", 0, 0, 50000);
        employeeMap.put(info1.getId(), info1);
        employeeMap.put(info2.getId(), info2);
        employeeMap.put(info3.getId(), info3);

        EmployeeRepositoryJavaMap employeeRepository = new EmployeeRepositoryJavaMap(employeeMap);

        // 테스트 수행
        List<ConvertableToEmployeeInfo> result = employeeRepository.findAllByCondition(
                new EmployeeSearchCondition("FullTime"));

        // 결과 검증
        List<EmployeeInfoMapEntity> expectedList = Arrays.asList(info1, info2);

        assertEquals(expectedList.size(), result.size(), "직원 수가 일치하지 않습니다.");
        assertTrue(result.containsAll(expectedList), "예상한 직원이 결과에 포함되어 있지 않습니다.");
    }

}
