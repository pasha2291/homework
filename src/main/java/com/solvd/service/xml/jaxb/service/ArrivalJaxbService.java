package com.solvd.service.xml.jaxb.service;

import com.solvd.entity.database.Arrival;
import com.solvd.service.xml.BaseXmlService;
import com.solvd.service.xml.jaxb.entity.Arrivals;

import java.util.List;

import static com.solvd.constant.XmlFileType.ARRIVALS;
import static com.solvd.service.xml.jaxb.parser.JaxbXmlFileParser.parseXmlJaxb;

public class ArrivalJaxbService implements BaseXmlService<Arrival> {

    @Override
    public List<Arrival> getList() {
        Arrivals arrivals = parseXmlJaxb(ARRIVALS);
        return arrivals.getArrivals();
    }
}
