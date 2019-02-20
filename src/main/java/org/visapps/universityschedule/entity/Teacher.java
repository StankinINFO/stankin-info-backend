package org.visapps.universityschedule.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@Entity
@Table(name = "Teacher", schema="Schedule")
@XmlAccessorType(XmlAccessType.FIELD)
public class Teacher {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Person person;
    private String comment;
    @XmlElement(name = "class_id")
    private Integer classId;
    @XmlElement(name = "subject_id")
    private Integer subjectId;
    @XmlElement(name = "room_id")
    private Integer roomId;
    @XmlElement(name = "chair_id")
    private Integer chairId;
    @XmlElement(name = "method_days")
    private Integer methodDays;
    @XmlElement(name = "max_windows")
    private Integer maxWindows;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @XmlElementWrapper(name="work_hours")
    @XmlElement(name = "week")
    private List<Week> workHours;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getChairId() {
        return chairId;
    }

    public void setChairId(Integer chairId) {
        this.chairId = chairId;
    }

    public Integer getMethodDays() {
        return methodDays;
    }

    public void setMethodDays(Integer methodDays) {
        this.methodDays = methodDays;
    }

    public Integer getMaxWindows() {
        return maxWindows;
    }

    public void setMaxWindows(Integer maxWindows) {
        this.maxWindows = maxWindows;
    }

    public List<Week> getWorkHours() {
        return workHours;
    }

    public void setWorkHours(List<Week> workHours) {
        this.workHours = workHours;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
