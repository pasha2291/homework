package com.solvd.service.xml.dom.service;

import com.solvd.constant.TableType;
import com.solvd.service.xml.BaseXmlService;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DomServiceManager {

    public static BaseXmlService getDomService(TableType type) {
        switch (type) {
            case AIRPORT: return new AirportDomService();
            case ARRIVAL: return new ArrivalDomService();
            case DEPARTURE: return new DepartureDomService();
            case CITY: return new CityDomService();
            case TICKET: return new TicketDomService();
            default: throw new IllegalArgumentException("There is no such dom service type");
        }
    }
}
