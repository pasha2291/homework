package com.solvd.entity.database;

import com.solvd.entity.SolvdEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "airport")
@XmlAccessorType(XmlAccessType.FIELD)
public class Airport implements SolvdEntity {
    private int id;
    private String airportCode;
}