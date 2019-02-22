package org.visapps.universityschedule.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@Document(collection = "term")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Term {

    @XmlElement(name = "first_lesson")
    private String firstLesson;
    @XmlElement(name = "sessions_per_day")
    private String sessionsPerDay;
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

}
