package com.solvd.constant;

import com.solvd.service.xml.jaxb.entity.Airports;
import com.solvd.service.xml.jaxb.entity.Arrivals;
import com.solvd.service.xml.jaxb.entity.Cities;
import com.solvd.service.xml.jaxb.entity.Departures;
import com.solvd.service.xml.jaxb.entity.Tickets;
import lombok.Getter;

import static com.solvd.constant.XmlFilePath.AIRPORTS_FILE;
import static com.solvd.constant.XmlFilePath.ARRIVALS_FILE;
import static com.solvd.constant.XmlFilePath.CITIES_FILE;
import static com.solvd.constant.XmlFilePath.DEPARTURES_FILE;
import static com.solvd.constant.XmlFilePath.TICKETS_FILE;
import static com.solvd.constant.XsdFilePath.AIRPORTS_SCHEMA;
import static com.solvd.constant.XsdFilePath.ARRIVALS_SCHEMA;
import static com.solvd.constant.XsdFilePath.CITIES_SCHEMA;
import static com.solvd.constant.XsdFilePath.DEPARTURES_SCHEMA;
import static com.solvd.constant.XsdFilePath.TICKETS_SCHEMA;

@Getter
public enum XmlFileType {
    AIRPORTS(AIRPORTS_FILE, AIRPORTS_SCHEMA, Airports.class),
    TICKETS(TICKETS_FILE, TICKETS_SCHEMA, Tickets.class),
    ARRIVALS(ARRIVALS_FILE, ARRIVALS_SCHEMA, Arrivals.class),
    DEPARTURES(DEPARTURES_FILE, DEPARTURES_SCHEMA, Departures.class),
    CITIES(CITIES_FILE, CITIES_SCHEMA, Cities.class);

    private final String filePath;
    private final String schemaPath;
    private final Class tClass;

    XmlFileType(String filePath, String schemaPath, Class tClass) {
        this.filePath = filePath;
        this.schemaPath = schemaPath;
        this.tClass = tClass;
    }
}
