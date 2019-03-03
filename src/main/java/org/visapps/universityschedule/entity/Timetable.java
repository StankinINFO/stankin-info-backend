package org.visapps.universityschedule.entity;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "timetable")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Timetable {

    @XmlElementWrapper(name="areas")
    @XmlElement(name="area")
    private List<Area> areas;

    @XmlElement(name = "term")
    private Terms term;

    @XmlElementWrapper(name="times")
    @XmlElement(name="time")
    private List<Time> times;

    @XmlElementWrapper(name="holidays")
    @XmlElement(name="day")
    private List<Holiday> holidays;

    @XmlElementWrapper(name="classes")
    @XmlElement(name="class")
    private List<Class> classes;

    @XmlElementWrapper(name="subjects")
    @XmlElement(name="subject")
    private List<Subject> subjects;

    @XmlElementWrapper(name="rooms")
    @XmlElement(name="room")
    private List<Room> rooms;

    @XmlElementWrapper(name="teachers")
    @XmlElement(name="teacher")
    private List<Teacher> teachers;

    @XmlElementWrapper(name="study_types")
    @XmlElement(name="study_type")
    private List<StudyType> studyTypes;

    @XmlElement(name = "loads")
    private Loads loads;

    @XmlElement(name = "scheds")
    private Scheds scheds;

    @XmlElementWrapper(name="chairs")
    @XmlElement(name="chair")
    private List<Chair> chairs;

    @XmlElementWrapper(name="specialities")
    @XmlElement(name="speciality")
    private List<Speciality> specialities;

    @XmlElementWrapper(name="plans")
    @XmlElement(name="plan")
    private List<Plan> plans;

}
