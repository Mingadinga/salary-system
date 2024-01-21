package com.hexagonal.salarysystem.adapter.out.persistence;

import com.hexagonal.salarysystem.application.port.out.EmployeeSearchCondition;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    Optional<ConvertableToEmployeeInfo> findEmployeeInfoById(long id);
    List<ConvertableToEmployeeInfo> findAllByCondition(EmployeeSearchCondition condition);
}
