package org.visapps.universityschedule.entity;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Week {

    @XmlElement(name = "day")
    private List<Day> day;
    @XmlAttribute(name = "i")
    private Integer i;

}
