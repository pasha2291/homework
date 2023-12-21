package com.solvd.service.dao_service;

import com.solvd.dao.FlightDao;
import com.solvd.entity.database.City;
import com.solvd.entity.database.Flight;

import java.time.Duration;

import static com.solvd.service.dao_service.TicketDaoService.getAverageTicketsCostByFlight;

public class FlightDaoService {
    private static final FlightDao FLIGHT_DAO = new FlightDao();

    public static String getFlightTimeBetweenCities(City cityOfDeparture, City cityOfArrival) {
        Flight flight = findFlightBetweenTwoCities(cityOfDeparture, cityOfArrival);
        return "Flight time between " + flight.getDeparture().getCity().getName() + " and " + flight.getArrival().getCity().getName()
                + " is approximately: " + Duration.between(flight.getDeparture().getDateTime(), flight.getArrival().getDateTime());
    }

    public static String getFlightAverageCostBetweenCities(City cityOfDeparture, City cityOfArrival) {
        Flight flight = findFlightBetweenTwoCities(cityOfDeparture, cityOfArrival);
        return "Flight cost between " + cityOfDeparture.getName() + " and " + cityOfArrival.getName()
                + "is approximately: " + getAverageTicketsCostByFlight(flight);
    }

    private static Flight findFlightBetweenTwoCities(City cityOfDeparture, City cityOfArrival) {
        return FLIGHT_DAO.getAll()
                .stream()
                .distinct()
                .filter(flight -> flight.getArrival().getCity().equals(cityOfArrival) && flight.getDeparture().getCity().equals(cityOfDeparture))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("There is no records with such departure and arrival cities in database"));
    }
}
