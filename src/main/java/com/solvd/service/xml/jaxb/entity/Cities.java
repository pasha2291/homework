package com.solvd.service.xml.jaxb.entity;

import com.solvd.entity.database.City;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name="cities")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cities {
    @XmlElement(name="city")
    private List<City> cities;
}
