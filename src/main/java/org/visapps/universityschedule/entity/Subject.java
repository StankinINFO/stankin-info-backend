package org.visapps.universityschedule.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Document(collection = "subjects")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Subject {

    @Id
    private Integer id;
    @XmlElement(name = "external_id")
    private Integer externalId;
    @XmlElement(name = "short_name")
    private String shortName;
    @XmlElement(name = "full_name")
    private String fullName;
    private String profile;
    @XmlElement(name = "area_id")
    private Integer areaId;

}
