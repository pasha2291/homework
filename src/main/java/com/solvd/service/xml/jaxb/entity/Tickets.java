package com.solvd.service.xml.jaxb.entity;

import com.solvd.entity.database.Ticket;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name="tickets")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tickets {
    @XmlElement(name="ticket")
    private List<Ticket> tickets;
}
