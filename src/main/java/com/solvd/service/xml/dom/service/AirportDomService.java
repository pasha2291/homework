package com.solvd.service.xml.dom.service;

import com.solvd.entity.database.Airport;
import com.solvd.service.xml.BaseXmlService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

import static com.solvd.constant.XmlFileType.AIRPORTS;
import static com.solvd.service.xml.dom.parser.DomXmlFileParser.validateAndParseXml;

public class AirportDomService implements BaseXmlService<Airport> {

    @Override
    public List<Airport> getList() {
        Document document = validateAndParseXml(AIRPORTS);
        Element element = document.getDocumentElement();
        NodeList list = element.getElementsByTagName("airport");
        List<Airport> result = new ArrayList<>(list.getLength());
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                Airport airport = new Airport();
                airport.setAirportCode(eElement.getElementsByTagName("airportCode").item(0).getTextContent());
                result.add(airport);
            }
        }
        return result;
    }
}
