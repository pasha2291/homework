package com.solvd.service.xml.jaxb.parser;

import com.solvd.constant.XmlFileType;
import lombok.experimental.UtilityClass;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static com.solvd.service.CustomLogger.logError;

@UtilityClass
public class JaxbXmlFileParser {
    private static final ClassLoader CLASS_LOADER = ClassLoader.getSystemClassLoader();

    public static <T> T parseXmlJaxb(XmlFileType fileType) {
        String fullPath = CLASS_LOADER.getResource(fileType.getFilePath()).getPath();
        File xmlFile = new File(fullPath);
        T object = null;
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(fileType.getTClass());
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            object = (T) jaxbUnmarshaller.unmarshal(xmlFile);

        } catch (JAXBException e) {
            logError("Unable to read or validate xml_file file: " + fullPath);
        }
        return object;
    }
}
