package com.hexagonal.salarysystem.adapter.out.persistence.java.map;

import com.hexagonal.salarysystem.adapter.out.persistence.ConvertableToEmployeeInfo;
import com.hexagonal.salarysystem.application.port.out.EmployeeInfo;

public class EmployeeInfoMapEntity implements ConvertableToEmployeeInfo {
    private long id;
    private String name;

    private String type;
    private int workHour;
    private long payPerHour;
    private long basePay;

    public EmployeeInfoMapEntity(long id, String name, String type, int workHour, long payPerHour, long basePay) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.workHour = workHour;
        this.payPerHour = payPerHour;
        this.basePay = basePay;
    }

    @Override
    public EmployeeInfo mapToEmployeeInfo() {
        return new EmployeeInfo(
                this.id,
                this.name,
                this.type,
                this.workHour,
                this.payPerHour,
                this.basePay);
    }

    public Long getId() {
        return this.id;
    }
}
