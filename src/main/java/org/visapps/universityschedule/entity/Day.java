package org.visapps.universityschedule.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.NONE)
public class Day {

    @XmlValue
    private Integer value;
    @XmlAttribute(name = "i")
    private Integer i;

}
