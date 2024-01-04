package com.solvd.service.xml.jaxb.service;

import com.solvd.entity.database.Departure;
import com.solvd.service.xml.BaseXmlService;
import com.solvd.service.xml.jaxb.entity.Departures;

import java.util.List;

import static com.solvd.constant.XmlFileType.DEPARTURES;
import static com.solvd.service.xml.jaxb.parser.JaxbXmlFileParser.parseXmlJaxb;

public class DepartureJaxbService implements BaseXmlService<Departure> {

    @Override
    public List<Departure> getList() {
        Departures departures = parseXmlJaxb(DEPARTURES);
        return departures.getDepartures();
    }
}
