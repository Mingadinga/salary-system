package com.hexagonal.salarysystem.adapter.out.persistence;

import java.util.Optional;

public interface EmployeeRepository {
    Optional<ConvertableToEmployeeInfo> findEmployeeInfoById(long id);
}
