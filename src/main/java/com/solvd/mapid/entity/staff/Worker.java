package com.solvd.mapid.entity.staff;

import com.solvd.mapid.entity.employee.*;

public class Worker extends Employee {
    public Worker(long id, FullName fullName, Department department, Contact contact, long manager, double salary) {
        super(id, fullName, department, Position.WORKER, contact, manager, salary);
    }
}
