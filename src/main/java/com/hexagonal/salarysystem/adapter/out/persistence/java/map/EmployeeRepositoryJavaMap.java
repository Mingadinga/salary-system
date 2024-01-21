package com.hexagonal.salarysystem.adapter.out.persistence.java.map;

import com.hexagonal.salarysystem.adapter.out.persistence.ConvertableToEmployeeInfo;
import com.hexagonal.salarysystem.adapter.out.persistence.EmployeeRepository;
import com.hexagonal.salarysystem.adapter.out.persistence.java.map.EmployeeInfoMapEntity;
import java.util.Map;
import java.util.Optional;

public class EmployeeRepositoryJavaMap implements EmployeeRepository {

    private Map<Long, EmployeeInfoMapEntity> map;

    public EmployeeRepositoryJavaMap(Map<Long, EmployeeInfoMapEntity> map) {
        this.map = map;
    }

    @Override
    public Optional<ConvertableToEmployeeInfo> findEmployeeInfoById(long id) {
        return Optional.ofNullable(map.get(id));
    }
}
