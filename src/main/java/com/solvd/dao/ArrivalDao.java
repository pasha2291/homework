package com.solvd.dao;

import com.solvd.connection_pool.ConnectionSource;
import com.solvd.entity.database.Airport;
import com.solvd.entity.database.Arrival;
import com.solvd.entity.database.City;
import com.solvd.entity.database.Departure;
import com.solvd.entity.database.Flight;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArrivalDao implements BaseDao<Arrival> {
    private static final String SELECT_ALL_QUERY = "SELECT id, airport, city, date_time FROM arrival";
    private static final String SELECT_BY_ID = "SELECT id, airport, city, date_time FROM arrival WHERE id = ?";

    @Override
    public Optional<Arrival> getById(int id) {
        Optional<Arrival> result = Optional.empty();
        try (PreparedStatement statement = ConnectionSource.instance().createConnection().prepareStatement(SELECT_BY_ID)) {
            statement.setString(1, String.valueOf(id));
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Arrival arrival = getArrival(rs);
                result = Optional.of(arrival);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Arrival> getAll() {
        List<Arrival> arrivals = new ArrayList<>();
        try (PreparedStatement statement = ConnectionSource.instance().createConnection().prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Arrival arrival = getArrival(rs);
                arrivals.add(arrival);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return arrivals;
    }

    private Arrival getArrival(ResultSet resultSet) throws SQLException {
        return new Arrival(
                resultSet.getInt("id"),
                resultSet.getObject("airport", Airport.class),
                resultSet.getObject("city", City.class),
                resultSet.getTimestamp("date_time").toLocalDateTime()
        );
    }
}
