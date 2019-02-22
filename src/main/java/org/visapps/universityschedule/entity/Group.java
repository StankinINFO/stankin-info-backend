package org.visapps.universityschedule.entity;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Group {

    @XmlElement(name = "teacher_id")
    private Integer teacherId;
    @XmlElement(name = "subject_id")
    private Integer subjectId;
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
    @XmlElementWrapper(name="hour_per_week_list")
    @XmlElement(name="int")
    private List<Integer> hourPerWeekList;

}
