package com.solvd.service.xml.dom.service;

import com.solvd.entity.database.Airport;
import com.solvd.entity.database.City;
import com.solvd.entity.database.Departure;
import com.solvd.service.xml.BaseXmlService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.constant.XmlFileType.DEPARTURES;
import static com.solvd.service.xml.dom.parser.DomXmlFileParser.validateAndParseXml;

public class DepartureDomService implements BaseXmlService<Departure> {

    @Override
    public List<Departure> getList() {
        Document document = validateAndParseXml(DEPARTURES);
        Element element = document.getDocumentElement();
        NodeList list = element.getElementsByTagName("departure");
        List<Departure> result = new ArrayList<>(list.getLength());
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                Departure departure = new Departure();
                departure.setDateTime(LocalDateTime.parse(eElement.getElementsByTagName("dateTime").item(0).getTextContent()));
                Node airportNode = eElement.getElementsByTagName("airport").item(0);
                Element airportElement = (Element)airportNode;
                Airport airport = new Airport();
                airport.setAirportCode(airportElement.getElementsByTagName("airportCode").item(0).getTextContent());
                departure.setAirport(airport);
                Node cityNode = eElement.getElementsByTagName("city").item(0);
                Element cityElement = (Element)cityNode;
                City city = new City();
                city.setName(cityElement.getElementsByTagName("name").item(0).getTextContent());
                city.setCountry(cityElement.getElementsByTagName("country").item(0).getTextContent());
                departure.setCity(city);
                result.add(departure);
            }
        }
        return result;
    }
}
