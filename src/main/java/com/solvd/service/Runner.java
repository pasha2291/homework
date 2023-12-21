package com.solvd.service;


import com.solvd.entity.database.City;

import java.util.List;

import static com.solvd.service.CustomLogger.logInfo;
import static com.solvd.service.dao_service.CityDaoService.getAllDistinctCitiesSortedByName;
import static com.solvd.service.dao_service.FlightDaoService.getFlightAverageCostBetweenCities;
import static com.solvd.service.dao_service.FlightDaoService.getFlightTimeBetweenCities;

public class Runner {
    public static void main(String[] args) {
        List<City> allCities = getAllDistinctCitiesSortedByName();
        logInfo("All available cities to visit: " + allCities);

        City cityOfDeparture = allCities.get(3);
        City cityOfArrival = allCities.get(14);

        logInfo(getFlightTimeBetweenCities(cityOfDeparture, cityOfArrival));
        logInfo(getFlightAverageCostBetweenCities(cityOfDeparture, cityOfArrival));
    }
}