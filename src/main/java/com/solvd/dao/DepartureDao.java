package com.solvd.dao;

import com.solvd.connection_pool.ConnectionSource;
import com.solvd.entity.database.Airport;
import com.solvd.entity.database.City;
import com.solvd.entity.database.Departure;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DepartureDao implements BaseDao<Departure> {
    private static final String SELECT_ALL_QUERY = "SELECT id, airport, city, date_time FROM departure";
    private static final String SELECT_BY_ID = "SELECT id, airport, city, date_time FROM departure WHERE id = ?";

    @Override
    public Optional<Departure> getById(int id) {
        Optional<Departure> result = Optional.empty();
        try (PreparedStatement statement = ConnectionSource.instance().createConnection().prepareStatement(SELECT_BY_ID)) {
            statement.setString(1, String.valueOf(id));
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Departure departure = getDeparture(rs);
                result = Optional.of(departure);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Departure> getAll() {
        List<Departure> departures = new ArrayList<>();
        try (PreparedStatement statement = ConnectionSource.instance().createConnection().prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Departure departure = getDeparture(rs);
                departures.add(departure);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return departures;
    }

    private Departure getDeparture(ResultSet resultSet) throws SQLException {
        return new Departure(
                resultSet.getInt("id"),
                resultSet.getObject("airport", Airport.class),
                resultSet.getObject("city", City.class),
                resultSet.getTimestamp("date_time").toLocalDateTime()
        );
    }
}
