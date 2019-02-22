package org.visapps.universityschedule.entity;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Session {

    @XmlElement(name = "first_hour")
    private String firstHour;
    @XmlAttribute(name = "index")
    private String index;

}
