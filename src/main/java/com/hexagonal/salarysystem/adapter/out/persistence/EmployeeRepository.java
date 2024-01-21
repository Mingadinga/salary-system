package com.hexagonal.salarysystem.adapter.out.persistence;

import com.hexagonal.salarysystem.adapter.out.persistence.java.map.EmployeeInfoMapEntity;
import java.util.Optional;

public interface EmployeeRepository {
    Optional<EmployeeInfoMapEntity> findEmployeeInfoById(long id);
}
