package com.solvd.mapid.entity.employee;

public class FullName {
    private final String firstName;
    private final String lastName;
    private final String middleName;

    public FullName(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }
}
