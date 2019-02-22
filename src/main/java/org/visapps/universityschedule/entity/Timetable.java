package org.visapps.universityschedule.entity;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "timetable")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter @Setter
public class Timetable {

    @XmlElementWrapper(name="teachers")
    @XmlElement(name="teacher")
    private List<Teacher> teachers;

}
