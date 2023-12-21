package com.solvd.dao;

import com.solvd.connection_pool.ConnectionSource;
import com.solvd.entity.database.City;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CityDao implements BaseDao<City> {
    private static final String SELECT_ALL_QUERY = "SELECT id, name, country FROM city";
    private static final String SELECT_BY_ID = "SELECT id, name, country FROM city WHERE id = ?";

    @Override
    public Optional<City> getById(int id) {
        Optional<City> result = Optional.empty();
        try (PreparedStatement statement = ConnectionSource.instance().createConnection().prepareStatement(SELECT_BY_ID)) {
            statement.setString(1, String.valueOf(id));
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                City city = getCity(rs);
                result = Optional.of(city);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return result;
    }

    @Override
    public List<City> getAll() {
        List<City> cities = new ArrayList<>();
        try (PreparedStatement statement = ConnectionSource.instance().createConnection().prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                City city = getCity(rs);
                cities.add(city);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return cities;
    }

    private City getCity(ResultSet resultSet) throws SQLException {
        return new City(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("country")
        );
    }
}
