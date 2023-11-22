package com.solvd.mapid.entity.staff;

import com.solvd.mapid.entity.employee.*;

public class ChiefEngineer extends Employee {
    public ChiefEngineer(FullName fullName, Contact contact, double salary) {
        super(2, fullName, new Department(2, "Engineering", "office 902"),
                Position.CHIEF_ENGINEER, contact, 1L, salary);
    }
}
