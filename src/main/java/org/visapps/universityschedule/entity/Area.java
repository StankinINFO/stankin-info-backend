package org.visapps.universityschedule.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Document(collection = "areas")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Area {

    @Id
    @XmlElement(name = "id")
    private Integer id;
    @XmlElement(name = "external_id")
    private Integer externalId;
    @XmlElement(name = "name")
    private String name;

}
