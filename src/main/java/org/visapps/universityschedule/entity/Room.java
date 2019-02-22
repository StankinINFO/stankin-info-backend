package org.visapps.universityschedule.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@Document(collection = "rooms")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Room {

    @Id
    private Integer id;
    @XmlElement(name = "external_id")
    private Integer externalId;
    private String name;
    private Integer capacity;
    private Integer building;
    @XmlElement(name = "chair_id")
    private Integer chairId;
    @XmlElementWrapper(name="work_hours")
    @XmlElement(name = "week")
    private List<Week> workHours;

}
