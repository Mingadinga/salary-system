package com.hexagonal.salarysystem.application.port.out;

public class EmployeeSearchCondition {
    private String type;

    public EmployeeSearchCondition(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
