package com.solvd.mapid.entity.employee;

public abstract class Employee {
    public long id;
    public FullName fullName;
    public Department department;
    public Position position;
    public Contact contact;
    public long manager;
    private double salary;

    public Employee(long id, FullName fullName, Department department, Position position, Contact contact, long manager, double salary) {
        this.id = id;
        this.fullName = fullName;
        this.department = department;
        this.position = position;
        this.contact = contact;
        this.manager = manager;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}
