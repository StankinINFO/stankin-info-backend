package org.visapps.universityschedule.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlValue;

@Document(collection = "holidays")
@XmlAccessorType(XmlAccessType.NONE)
@Getter
@Setter
public class Holiday {

    @Id
    private Integer id;

    @XmlValue
    private String value;

}
