package org.visapps.universityschedule.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@Entity
@Table(name = "Term", schema="Schedule")
@XmlAccessorType(XmlAccessType.FIELD)
public class Term {

    @Id
    private Integer id;

    @XmlElement(name = "first_lesson")
    private String firstLesson;
    @XmlElement(name = "sessions_per_day")
    private String sessionsPerDay;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @XmlElementWrapper(name="sessions")
    @XmlElement(name="session")
    private List<Session> sessions;
    @XmlElement(name = "miss_first_lesson")
    private String missFirstLesson;
    @XmlElement(name = "univer_system")
    private String univerSystem;
    @XmlElement(name = "max_lessons_per_session")
    private String maxLessonsPerSession;
    @XmlElement(name = "begin_date")
    private String beginDate;
    @XmlElement(name = "end_date")
    private String endDate;
    @XmlElement(name = "current_week_begin")
    private String currentWeekBegin;
    @XmlElement(name = "max_day")
    private String maxDay;
    @XmlElement(name = "first_semester")
    private String firstSemester;
    @XmlElement(name = "max_semester")
    private String maxSemester;
    private String transit;
    @XmlElement(name = "correct_loads")
    private String correctLoads;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstLesson() {
        return firstLesson;
    }

    public void setFirstLesson(String firstLesson) {
        this.firstLesson = firstLesson;
    }

    public String getSessionsPerDay() {
        return sessionsPerDay;
    }

    public void setSessionsPerDay(String sessionsPerDay) {
        this.sessionsPerDay = sessionsPerDay;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public String getMissFirstLesson() {
        return missFirstLesson;
    }

    public void setMissFirstLesson(String missFirstLesson) {
        this.missFirstLesson = missFirstLesson;
    }

    public String getUniverSystem() {
        return univerSystem;
    }

    public void setUniverSystem(String univerSystem) {
        this.univerSystem = univerSystem;
    }

    public String getMaxLessonsPerSession() {
        return maxLessonsPerSession;
    }

    public void setMaxLessonsPerSession(String maxLessonsPerSession) {
        this.maxLessonsPerSession = maxLessonsPerSession;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCurrentWeekBegin() {
        return currentWeekBegin;
    }

    public void setCurrentWeekBegin(String currentWeekBegin) {
        this.currentWeekBegin = currentWeekBegin;
    }

    public String getMaxDay() {
        return maxDay;
    }

    public void setMaxDay(String maxDay) {
        this.maxDay = maxDay;
    }

    public String getFirstSemester() {
        return firstSemester;
    }

    public void setFirstSemester(String firstSemester) {
        this.firstSemester = firstSemester;
    }

    public String getMaxSemester() {
        return maxSemester;
    }

    public void setMaxSemester(String maxSemester) {
        this.maxSemester = maxSemester;
    }

    public String getTransit() {
        return transit;
    }

    public void setTransit(String transit) {
        this.transit = transit;
    }

    public String getCorrectLoads() {
        return correctLoads;
    }

    public void setCorrectLoads(String correctLoads) {
        this.correctLoads = correctLoads;
    }

}
