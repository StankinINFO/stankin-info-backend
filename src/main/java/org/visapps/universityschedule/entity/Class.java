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

@Document(collection = "classes")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Class {

    @Id
    private Integer id;
    @XmlElement(name = "external_id")
    private Integer externalId;
    private String name;
    private Integer session;
    private Integer student;
    @XmlElement(name = "min_lessons_per_day")
    private Integer minLessonsPerDay;
    @XmlElement(name = "max_lessons_per_day")
    private Integer maxLessonsPerDay;
    @XmlElement(name = "max_load_per_week")
    private Integer maxLoadPerWeek;
    @XmlElementWrapper(name="work_hours")
    @XmlElement(name = "week")
    private List<Week> workHours;
    @XmlElement(name = "speciality_id")
    private Integer specialityId;
    private Integer semester;

}
