package com.solvd.service.xml.jaxb.entity;

import com.solvd.entity.database.Airport;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name="airports")
@XmlAccessorType(XmlAccessType.FIELD)
public class Airports {
    @XmlElement(name="airport")
    private List<Airport> airports;
}
