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

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getWorkHour() {
        return workHour;
    }

    public long getPayPerHour() {
        return payPerHour;
    }

    public long getBasePay() {
        return basePay;
    }

    @Override
    public EmployeeInfo mapToEmployeeInfo() {
        return new EmployeeInfo(
                this.getId(),
                this.getName(),
                this.getType(),
                this.getWorkHour(),
                this.getPayPerHour(),
                this.getBasePay());
    }
}
