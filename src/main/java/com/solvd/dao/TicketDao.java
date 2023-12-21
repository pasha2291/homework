package com.solvd.dao;

import com.solvd.connection_pool.ConnectionSource;
import com.solvd.entity.database.Ticket;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketDao implements BaseDao<Ticket>{
    private static final String SELECT_ALL_QUERY = "SELECT id, flight_id, cost FROM ticket";
    private static final String SELECT_BY_ID = "SELECT id, flight_id, cost FROM ticket WHERE id = ?";

    @Override
    public Optional<Ticket> getById(int id) {
        Optional<Ticket> result = Optional.empty();
        try (PreparedStatement statement = ConnectionSource.instance().createConnection().prepareStatement(SELECT_BY_ID)) {
            statement.setString(1, String.valueOf(id));
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Ticket ticket = getTicket(rs);
                result = Optional.of(ticket);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Ticket> getAll() {
        List<Ticket> tickets = new ArrayList<>();
        try (PreparedStatement statement = ConnectionSource.instance().createConnection().prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Ticket ticket = getTicket(rs);
                tickets.add(ticket);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return tickets;
    }

    private Ticket getTicket(ResultSet resultSet) throws SQLException {
        return new Ticket(
                resultSet.getInt("id"),
                resultSet.getInt("flight_id"),
                resultSet.getInt("cost")
        );
    }
}
