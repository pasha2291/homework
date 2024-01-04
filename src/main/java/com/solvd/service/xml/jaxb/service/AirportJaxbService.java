package com.solvd.service.xml.jaxb.service;

import com.solvd.entity.database.Airport;
import com.solvd.service.xml.BaseXmlService;
import com.solvd.service.xml.jaxb.entity.Airports;

import java.util.List;

import static com.solvd.constant.XmlFileType.AIRPORTS;
import static com.solvd.service.xml.jaxb.parser.JaxbXmlFileParser.parseXmlJaxb;

public class AirportJaxbService implements BaseXmlService<Airport> {

    @Override
    public List<Airport> getList() {
        Airports airports = parseXmlJaxb(AIRPORTS);
        return airports.getAirports();
    }
}
