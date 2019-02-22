package org.visapps.universityschedule.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@Document(collection = "plans")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Plan {

    @Id
    private Integer id;
    @XmlElement(name = "external_id")
    private Integer externalId;
    @XmlElement(name = "speciality_id")
    private Integer specialityId;
    @XmlElement(name = "subject_id")
    private Integer subjectId;
    @XmlElementWrapper(name="semester_plans")
    @XmlElement(name="semester_plan")
    private List<SemesterPlan> semesterPlans;

}
