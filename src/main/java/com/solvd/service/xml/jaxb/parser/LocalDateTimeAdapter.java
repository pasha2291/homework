package com.solvd.service.xml.jaxb.parser;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

    public LocalDateTime unmarshal(String inputDate) {
        return inputDate != null ? LocalDateTime.parse(inputDate) : null;
    }

    public String marshal(LocalDateTime inputDate) {
        return inputDate != null ? DateTimeFormatter.ofPattern("yyyy-MM-ddTHH.mm.ss").format(inputDate) : null;
    }
}
