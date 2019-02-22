package org.visapps.universityschedule.entity;


import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter @Setter
public class Person {

    private Integer id;
    @XmlElement(name = "external_id")
    private Integer externalId;
    private String surname;
    @XmlElement(name = "first_name")
    private String firstName;
    @XmlElement(name = "second_name")
    private String secondName;

}
