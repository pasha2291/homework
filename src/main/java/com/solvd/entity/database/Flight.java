package com.solvd.entity.database;

import com.solvd.entity.SolvdEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Flight implements SolvdEntity {
    private int id;
    private String flightCode;
    private Departure departure;
    private Arrival arrival;
}