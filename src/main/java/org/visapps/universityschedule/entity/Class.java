package org.visapps.universityschedule.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@Entity
@Table(name = "Class", schema="Schedule")
@XmlAccessorType(XmlAccessType.FIELD)
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
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @XmlElementWrapper(name="work_hours")
    @XmlElement(name = "week")
    private List<Week> workHours;
    @XmlElement(name = "speciality_id")
    private Integer specialityId;
    private Integer semester;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExternalId() {
        return externalId;
    }

    public void setExternalId(Integer externalId) {
        this.externalId = externalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSession() {
        return session;
    }

    public void setSession(Integer session) {
        this.session = session;
    }

    public Integer getStudent() {
        return student;
    }

    public void setStudent(Integer student) {
        this.student = student;
    }

    public Integer getMinLessonsPerDay() {
        return minLessonsPerDay;
    }

    public void setMinLessonsPerDay(Integer minLessonsPerDay) {
        this.minLessonsPerDay = minLessonsPerDay;
    }

    public Integer getMaxLessonsPerDay() {
        return maxLessonsPerDay;
    }

    public void setMaxLessonsPerDay(Integer maxLessonsPerDay) {
        this.maxLessonsPerDay = maxLessonsPerDay;
    }

    public Integer getMaxLoadPerWeek() {
        return maxLoadPerWeek;
    }

    public void setMaxLoadPerWeek(Integer maxLoadPerWeek) {
        this.maxLoadPerWeek = maxLoadPerWeek;
    }

    public List<Week> getWorkHours() {
        return workHours;
    }

    public void setWorkHours(List<Week> workHours) {
        this.workHours = workHours;
    }

    public Integer getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Integer specialityId) {
        this.specialityId = specialityId;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

}
