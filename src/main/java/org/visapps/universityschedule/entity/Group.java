package org.visapps.universityschedule.entity;

import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@Entity
@Table(name = "Group", schema="Schedule")
@XmlAccessorType(XmlAccessType.FIELD)
public class Group {

    @Id
    @GeneratedValue
    private Integer id;

    @XmlElement(name = "teacher_id")
    private Integer teacherId;
    @XmlElement(name = "subject_id")
    private Integer subjectId;
    @ElementCollection
    @XmlElementWrapper(name="room_id_list")
    @XmlElement(name="int")
    private List<Integer> roomIdList;
    @XmlElement(name = "hours_total")
    private Integer hoursTotal;
    @XmlElement(name = "hours_per_week")
    private Integer hoursPerWeek;
    @XmlElement(name = "week_type")
    private String weekType;
    @XmlElement(name = "period_position")
    private String periodPosition;
    @XmlElement(name = "writing_book")
    private String writingBook;
    @XmlElement(name = "component_type")
    private String componentType;
    private String paid;
    @XmlElement(name = "pair_type")
    private String pairType;
    @XmlElement(name = "study_type_id")
    private Integer studyTypeId;
    @ElementCollection
    @XmlElementWrapper(name="hour_per_week_list")
    @XmlElement(name="int")
    private List<Integer> hourPerWeekList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public List<Integer> getRoomIdList() {
        return roomIdList;
    }

    public void setRoomIdList(List<Integer> roomIdList) {
        this.roomIdList = roomIdList;
    }

    public Integer getHoursTotal() {
        return hoursTotal;
    }

    public void setHoursTotal(Integer hoursTotal) {
        this.hoursTotal = hoursTotal;
    }

    public Integer getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(Integer hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    public String getWeekType() {
        return weekType;
    }

    public void setWeekType(String weekType) {
        this.weekType = weekType;
    }

    public String getPeriodPosition() {
        return periodPosition;
    }

    public void setPeriodPosition(String periodPosition) {
        this.periodPosition = periodPosition;
    }

    public String getWritingBook() {
        return writingBook;
    }

    public void setWritingBook(String writingBook) {
        this.writingBook = writingBook;
    }

    public String getComponentType() {
        return componentType;
    }

    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public String getPairType() {
        return pairType;
    }

    public void setPairType(String pairType) {
        this.pairType = pairType;
    }

    public Integer getStudyTypeId() {
        return studyTypeId;
    }

    public void setStudyTypeId(Integer studyTypeId) {
        this.studyTypeId = studyTypeId;
    }

    public List<Integer> getHourPerWeekList() {
        return hourPerWeekList;
    }

    public void setHourPerWeekList(List<Integer> hourPerWeekList) {
        this.hourPerWeekList = hourPerWeekList;
    }

}
