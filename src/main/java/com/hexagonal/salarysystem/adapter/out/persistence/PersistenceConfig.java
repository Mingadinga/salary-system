package com.hexagonal.salarysystem.adapter.out.persistence;

import com.hexagonal.salarysystem.adapter.out.persistence.java.map.EmployeeInfoMapEntity;
import com.hexagonal.salarysystem.adapter.out.persistence.java.map.EmployeeRepositoryJavaMap;
import com.hexagonal.salarysystem.application.port.out.LoadEmployeeInfoPort;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfig {

    @Bean
    public LoadEmployeeInfoPort loadEmployeeInfoPort() {
        return new EmployeePersistenceAdapter(employeeRepository());
    }

    @Bean
    public EmployeeRepository employeeRepository() {

        Map<Long, EmployeeInfoMapEntity> employeeMap = new HashMap<>();
        employeeMap.put(1L,  new EmployeeInfoMapEntity(101L, "정직원", "FullTime", 0, 0, 3_000_000));
        employeeMap.put(2L,  new EmployeeInfoMapEntity(102L, "김직원", "FullTime", 0, 0, 4_000_000));
        employeeMap.put(3L,  new EmployeeInfoMapEntity(103L, "이직원", "FullTime", 0, 0, 5_000_000));
        employeeMap.put(4L,  new EmployeeInfoMapEntity(201L, "김알바", "PartTime", 10, 10_000, 0));
        employeeMap.put(5L,  new EmployeeInfoMapEntity(202L, "이알바", "PartTime", 12, 9_000, 0));
        employeeMap.put(6L,  new EmployeeInfoMapEntity(203L, "박알바", "PartTime", 13, 11_000, 0));

        return new EmployeeRepositoryJavaMap(employeeMap);
    }
}
