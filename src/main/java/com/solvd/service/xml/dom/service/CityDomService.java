package com.solvd.service.xml.dom.service;

import com.solvd.entity.database.City;
import com.solvd.service.xml.BaseXmlService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

import static com.solvd.constant.XmlFileType.CITIES;
import static com.solvd.service.xml.dom.parser.DomXmlFileParser.validateAndParseXml;


public class CityDomService implements BaseXmlService<City> {

    @Override
    public List<City> getList() {
        Document document = validateAndParseXml(CITIES);
        Element element = document.getDocumentElement();
        NodeList list = element.getElementsByTagName("city");
        List<City> result = new ArrayList<>(list.getLength());
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                City city = new City();
                city.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                city.setCountry(eElement.getElementsByTagName("country").item(0).getTextContent());
                result.add(city);
            }
        }
        return result;
    }
}
