package com.solvd.service.xml.jaxb.service;

import com.solvd.constant.TableType;
import com.solvd.service.xml.BaseXmlService;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JaxbServiceManager {

    public static BaseXmlService getJaxbService(TableType type) {
        switch (type) {
            case AIRPORT: return new AirportJaxbService();
            case ARRIVAL: return new ArrivalJaxbService();
            case DEPARTURE: return new DepartureJaxbService();
            case CITY: return new CityJaxbService();
            case TICKET: return new TicketJaxbService();
            default: throw new IllegalArgumentException("There is no such jaxb service type");
        }
    }
}
