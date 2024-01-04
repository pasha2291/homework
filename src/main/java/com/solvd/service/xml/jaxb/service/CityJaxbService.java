package com.solvd.service.xml.jaxb.service;

import com.solvd.entity.database.City;
import com.solvd.service.xml.BaseXmlService;
import com.solvd.service.xml.jaxb.entity.Cities;

import java.util.List;

import static com.solvd.constant.XmlFileType.CITIES;
import static com.solvd.service.xml.jaxb.parser.JaxbXmlFileParser.parseXmlJaxb;

public class CityJaxbService implements BaseXmlService<City> {

    @Override
    public List<City> getList() {
        Cities cities = parseXmlJaxb(CITIES);
        return cities.getCities();
    }
}
