package org.visapps.universityschedule.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@Entity
@Table(name = "SemesterPlan", schema="Schedule")
@XmlAccessorType(XmlAccessType.FIELD)
public class SemesterPlan {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer semester;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @XmlElementWrapper(name="study_type_list")
    @XmlElement(name="element")
    private List<Element> studyTypeList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public List<Element> getStudyTypeList() {
        return studyTypeList;
    }

    public void setStudyTypeList(List<Element> studyTypeList) {
        this.studyTypeList = studyTypeList;
    }

}
