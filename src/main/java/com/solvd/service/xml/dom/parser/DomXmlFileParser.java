package com.solvd.service.xml.dom.parser;

import com.solvd.constant.XmlFileType;
import org.w3c.dom.Document;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

import static com.solvd.service.CustomLogger.logError;

public class DomXmlFileParser {
    private static final ClassLoader CLASS_LOADER = ClassLoader.getSystemClassLoader();

    public static Document validateAndParseXml(XmlFileType fileType) {
        Document document = parseXmlDom(fileType.getFilePath());
        validateXml(fileType.getSchemaPath(), document);
        return document;
    }

    private static void validateXml(String schemaFilePath, Document document) {
        try {
            String fullPath = CLASS_LOADER.getResource(schemaFilePath).getPath();
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(fullPath));
            Validator validator = schema.newValidator();
            validator.validate(new DOMSource(document));
        } catch (Exception e) {
            logError("Unable to read or validate xsd_schema file: " + schemaFilePath);
        }
    }

    private static Document parseXmlDom(String xmlFilePath) {
        Document document = null;
        try {
            String fullPath = CLASS_LOADER.getResource(xmlFilePath).getPath();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(new File(fullPath));
        } catch (Exception e) {
            logError("Unable to read or validate xml_file file: " + xmlFilePath);
        }
        return document;
    }
}
