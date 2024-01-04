package com.solvd.constant;

public class XsdFilePath {
    private static final String SCHEMA_PATH = "xsd_schema/%s";
    public static final String CITIES_SCHEMA = String.format(SCHEMA_PATH, "citiesSchema.xsd");
    public static final String AIRPORTS_SCHEMA = String.format(SCHEMA_PATH, "airportsSchema.xsd");
    public static final String TICKETS_SCHEMA = String.format(SCHEMA_PATH, "ticketsSchema.xsd");
    public static final String ARRIVALS_SCHEMA = String.format(SCHEMA_PATH, "arrivalsSchema.xsd");
    public static final String DEPARTURES_SCHEMA = String.format(SCHEMA_PATH, "departuresSchema.xsd");
}
