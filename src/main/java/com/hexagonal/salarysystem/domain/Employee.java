package com.hexagonal.salarysystem.domain;

public abstract class Employee {

    Long id;
    String name;

    public abstract Money calculateSalary();

}
