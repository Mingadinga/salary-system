package com.hexagonal.salarysystem.application.port.out;

public class EmployeeInfo {
    private long id;
    private String name;

    /**
     * 직원 타입 : FullTime, PartTime
     */
    private String type;
    /**
     * 아르바이트생 필드 : workHour, payPerHour
     */
    private int workHour;
    private long payPerHour;
    /**
     * 정직원 필드 : basePay
     */
    private long basePay;

    public EmployeeInfo(long id, String name, String type, int workHour, long payPerHour, long basePay) {
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
}
