package org.visapps.universityschedule.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@Entity
@Table(name = "Load", schema="Schedule")
@XmlAccessorType(XmlAccessType.FIELD)
public class Load {

    @Id
    private Integer id;
    @XmlElement(name = "external_id")
    private Integer externalId;
    @XmlElement(name = "same_time")
    private String sameTime;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @XmlElementWrapper(name="groups")
    @XmlElement(name="group")
    private List<Group> groups;
    @ElementCollection
    @XmlElementWrapper(name="klass_id_list")
    @XmlElement(name="int")
    private List<Integer> klassIdList;

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

    public String getSameTime() {
        return sameTime;
    }

    public void setSameTime(String sameTime) {
        this.sameTime = sameTime;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Integer> getKlassIdList() {
        return klassIdList;
    }

    public void setKlassIdList(List<Integer> klassIdList) {
        this.klassIdList = klassIdList;
    }

}
