package com.solvd.service.xml.dom.service;

import com.solvd.entity.database.Ticket;
import com.solvd.service.xml.BaseXmlService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

import static com.solvd.constant.XmlFileType.TICKETS;
import static com.solvd.service.xml.dom.parser.DomXmlFileParser.validateAndParseXml;

public class TicketDomService implements BaseXmlService<Ticket> {

    @Override
    public List<Ticket> getList() {
        Document document = validateAndParseXml(TICKETS);
        Element element = document.getDocumentElement();
        NodeList list = element.getElementsByTagName("ticket");
        List<Ticket> result = new ArrayList<>(list.getLength());
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                Ticket ticket = new Ticket();
                ticket.setCost(Integer.parseInt(eElement.getElementsByTagName("cost").item(0).getTextContent()));
                ticket.setFlightId(Integer.parseInt(eElement.getElementsByTagName("flightId").item(0).getTextContent()));
                result.add(ticket);
            }
        }
        return result;
    }
}
