package com.solvd.mapid.entity.staff;

import com.solvd.mapid.entity.employee.*;

public class CEO extends Employee {
    public CEO(FullName fullName, Contact contact, double salary) {
        super(1, fullName, new Department(1, "Administration", "office 901"),
                Position.PRESIDENT, contact, 1, salary);
    }
}
