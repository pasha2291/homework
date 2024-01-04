package com.solvd.entity.database;

import com.solvd.entity.SolvdEntity;
import com.solvd.service.xml.jaxb.parser.LocalDateTimeAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "departure")
@XmlAccessorType(XmlAccessType.FIELD)
public class Departure implements SolvdEntity {
    private int id;
    private Airport airport;
    private City city;
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime dateTime;
}
