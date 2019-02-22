package org.visapps.universityschedule.entity;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Study {

    @XmlElement(name = "int1")
    private Integer studyTypeId;
    @XmlElement(name = "int2")
    private Integer hours;

}
