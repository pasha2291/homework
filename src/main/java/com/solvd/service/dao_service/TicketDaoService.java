package com.solvd.service.dao_service;

import com.solvd.dao.TicketDao;
import com.solvd.entity.database.Flight;
import com.solvd.entity.database.Ticket;

public class TicketDaoService {
    private static final TicketDao TICKET_DAO = new TicketDao();

    public static double getAverageTicketsCostByFlight(Flight flight) {
         return TICKET_DAO.getAll()
                 .stream()
                 .filter(ticket -> ticket.getFlightId() == flight.getId())
                 .mapToInt(Ticket::getCost)
                 .average()
                 .orElseThrow(() -> new IllegalArgumentException("There is no data to count average cost."));
    }
}
