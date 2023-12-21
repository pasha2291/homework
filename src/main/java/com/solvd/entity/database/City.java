package com.solvd.entity.database;

import com.solvd.entity.SolvdEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class City implements SolvdEntity {
    private int id;
    private String name;
    private String country;
}