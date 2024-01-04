package com.solvd.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class XmlFilePath {
    private static final String XML_FILE_PATH = "xml_file/%s";
    public static final String CITIES_FILE = String.format(XML_FILE_PATH, "cities.xml");
    public static final String AIRPORTS_FILE = String.format(XML_FILE_PATH, "airports.xml");
    public static final String TICKETS_FILE = String.format(XML_FILE_PATH, "tickets.xml");
    public static final String ARRIVALS_FILE = String.format(XML_FILE_PATH, "arrivals.xml");
    public static final String DEPARTURES_FILE = String.format(XML_FILE_PATH, "departures.xml");
}
