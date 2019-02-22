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

@Document(collection = "loads")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Load {

    @Id
    private Integer id;
    @XmlElement(name = "external_id")
    private Integer externalId;
    @XmlElement(name = "same_time")
    private String sameTime;
    @XmlElementWrapper(name="groups")
    @XmlElement(name="group")
    private List<Group> groups;
    @XmlElementWrapper(name="klass_id_list")
    @XmlElement(name="int")
    private List<Integer> klassIdList;

}
