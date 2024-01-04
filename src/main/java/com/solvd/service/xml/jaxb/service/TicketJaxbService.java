package com.solvd.service.xml.jaxb.service;

import com.solvd.entity.database.Ticket;
import com.solvd.service.xml.BaseXmlService;
import com.solvd.service.xml.jaxb.entity.Tickets;

import java.util.List;

import static com.solvd.constant.XmlFileType.TICKETS;
import static com.solvd.service.xml.jaxb.parser.JaxbXmlFileParser.parseXmlJaxb;

public class TicketJaxbService implements BaseXmlService<Ticket> {

    @Override
    public List<Ticket> getList() {
        Tickets tickets = parseXmlJaxb(TICKETS);
        return tickets.getTickets();
    }
}
