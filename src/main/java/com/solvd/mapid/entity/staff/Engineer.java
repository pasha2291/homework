package com.solvd.mapid.entity.staff;

import com.solvd.mapid.entity.employee.*;

public class Engineer extends Employee {
    public Engineer(long id, FullName fullName, Contact contact, double salary) {
        super(id, fullName, new Department(2, "Engineering", "office 902"),
                Position.ENGINEER, contact, 2, salary);
    }
}
