package com.solvd.entity.database;

import com.solvd.entity.SolvdEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Departure implements SolvdEntity {
    private int id;
    private Airport airport;
    private City city;
    private LocalDateTime dateTime;
}
