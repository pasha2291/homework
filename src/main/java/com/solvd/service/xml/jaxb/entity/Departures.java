package com.solvd.service.xml.jaxb.entity;

import com.solvd.entity.database.Departure;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name="departures")
@XmlAccessorType(XmlAccessType.FIELD)
public class Departures {
    @XmlElement(name="departure")
    private List<Departure> departures;
}
