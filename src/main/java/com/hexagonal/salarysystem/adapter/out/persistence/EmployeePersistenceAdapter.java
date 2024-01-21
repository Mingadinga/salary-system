package com.hexagonal.salarysystem.adapter.out.persistence;

import com.hexagonal.salarysystem.adapter.out.persistence.java.map.EmployeeInfoMapEntity;
import com.hexagonal.salarysystem.application.port.out.EmployeeInfo;
import com.hexagonal.salarysystem.application.port.out.LoadEmployeeInfoPort;

public class EmployeePersistenceAdapter implements LoadEmployeeInfoPort {
    private final EmployeeRepository employeeRepository;

    public EmployeePersistenceAdapter(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeInfo loadOrElseThrow(long employeeId) {
        EmployeeInfoMapEntity entity = employeeRepository.findEmployeeInfoById(employeeId)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 직원입니다. 요청한 아이디 : " + employeeId));
        return entity.mapToEmployeeInfo();
    }
}
