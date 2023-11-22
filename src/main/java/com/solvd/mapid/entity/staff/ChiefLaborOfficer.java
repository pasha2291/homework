package com.solvd.mapid.entity.staff;

import com.solvd.mapid.entity.employee.*;

public class ChiefLaborOfficer extends Employee {
    public ChiefLaborOfficer(FullName fullName, Contact contact, double salary) {
        super(3, fullName, new Department(1, "Administration", "office 901"),
                Position.CHIEF_LABOR_OFFICER, contact, 1, salary);
    }
}
