package org.visapps.universityschedule.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@Entity
@Table(name = "Plan", schema="Schedule")
@XmlAccessorType(XmlAccessType.FIELD)
public class Plan {

    @Id
    private Integer id;
    @XmlElement(name = "external_id")
    private Integer externalId;
    @XmlElement(name = "speciality_id")
    private Integer specialityId;
    @XmlElement(name = "subject_id")
    private Integer subjectId;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @XmlElementWrapper(name="semester_plans")
    @XmlElement(name="semester_plan")
    private List<SemesterPlan> semesterPlans;

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

    public Integer getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Integer specialityId) {
        this.specialityId = specialityId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public List<SemesterPlan> getSemesterPlans() {
        return semesterPlans;
    }

    public void setSemesterPlans(List<SemesterPlan> semesterPlans) {
        this.semesterPlans = semesterPlans;
    }

}
