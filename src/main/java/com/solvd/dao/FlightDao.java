package com.solvd.dao;

import com.solvd.connection_pool.ConnectionSource;
import com.solvd.entity.database.Arrival;
import com.solvd.entity.database.Departure;
import com.solvd.entity.database.Flight;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightDao implements BaseDao<Flight> {
    private static final String SELECT_ALL_QUERY = "SELECT id, flight_code, departure, arrival FROM flight";
    private static final String SELECT_BY_ID = "SELECT id, flight_code, departure, arrival FROM flight WHERE id = ?";

    @Override
    public Optional<Flight> getById(int id) {
        Optional<Flight> result = Optional.empty();
        try (PreparedStatement statement = ConnectionSource.instance().createConnection().prepareStatement(SELECT_BY_ID)) {
            statement.setString(1, String.valueOf(id));
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Flight flight = getFlight(rs);
                result = Optional.of(flight);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Flight> getAll() {
        List<Flight> flights = new ArrayList<>();
        try (PreparedStatement statement = ConnectionSource.instance().createConnection().prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Flight flight = getFlight(rs);
                flights.add(flight);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return flights;
    }

    private Flight getFlight(ResultSet resultSet) throws SQLException {
        return new Flight(
                resultSet.getInt("id"),
                resultSet.getString("flight_code"),
                resultSet.getObject("departure", Departure.class),
                resultSet.getObject("arrival", Arrival.class)
        );
    }
}
