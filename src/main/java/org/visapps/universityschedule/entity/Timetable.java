package org.visapps.universityschedule.entity;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "timetable")
@XmlAccessorType(XmlAccessType.FIELD)
public class Timetable {

    @XmlElement(name = "format")
    private Format format;
    @XmlElement(name = "general")
    private General general;
    @XmlElementWrapper(name="areas")
    @XmlElement(name="area")
    private List<Area> areas;
    @XmlElement(name = "term")
    private Term term;
    @XmlElementWrapper(name="times")
    @XmlElement(name="time")
    private List<Time> times;
    @XmlElementWrapper(name="holidays")
    @XmlElement(name="day")
    private List<Holiday> holidays;
    @XmlElement(name="weights")
    private Weights weights;
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

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public General getGeneral() {
        return general;
    }

    public void setGeneral(General general) {
        this.general = general;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public List<Time> getTimes() {
        return times;
    }

    public void setTimes(List<Time> times) {
        this.times = times;
    }

    public List<Holiday> getHolidays() {
        return holidays;
    }

    public void setHolidays(List<Holiday> holidays) {
        this.holidays = holidays;
    }

    public Weights getWeights() {
        return weights;
    }

    public void setWeights(Weights weights) {
        this.weights = weights;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<StudyType> getStudyTypes() {
        return studyTypes;
    }

    public void setStudyTypes(List<StudyType> studyTypes) {
        this.studyTypes = studyTypes;
    }

    public Loads getLoads() {
        return loads;
    }

    public void setLoads(Loads loads) {
        this.loads = loads;
    }

    public Scheds getScheds() {
        return scheds;
    }

    public void setScheds(Scheds scheds) {
        this.scheds = scheds;
    }

    public List<Chair> getChairs() {
        return chairs;
    }

    public void setChairs(List<Chair> chairs) {
        this.chairs = chairs;
    }

    public List<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(List<Speciality> specialities) {
        this.specialities = specialities;
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public void setPlans(List<Plan> plans) {
        this.plans = plans;
    }
}
