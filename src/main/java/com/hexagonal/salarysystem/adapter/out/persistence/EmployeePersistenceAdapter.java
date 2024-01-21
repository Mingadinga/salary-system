package com.hexagonal.salarysystem.adapter.out.persistence;

import com.hexagonal.salarysystem.application.port.out.EmployeeInfo;
import com.hexagonal.salarysystem.application.port.out.EmployeeSearchCondition;
import com.hexagonal.salarysystem.application.port.out.LoadEmployeeInfoPort;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeePersistenceAdapter implements LoadEmployeeInfoPort {
    private final EmployeeRepository employeeRepository;

    public EmployeePersistenceAdapter(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeInfo loadOrElseThrow(long employeeId) {
        ConvertableToEmployeeInfo entity = employeeRepository.findEmployeeInfoById(employeeId)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 직원입니다. 요청한 아이디 : " + employeeId));
        return entity.mapToEmployeeInfo();
    }

    @Override
    public List<EmployeeInfo> loadAllByCondition(EmployeeSearchCondition condition) {
        List<ConvertableToEmployeeInfo> satisfyingEntities = employeeRepository.findAllByCondition(condition);
        return satisfyingEntities.stream().map(ConvertableToEmployeeInfo::mapToEmployeeInfo).collect(Collectors.toList());
    }
}
