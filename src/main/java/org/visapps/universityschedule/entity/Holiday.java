package org.visapps.universityschedule.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlValue;

@Entity
@Table(name = "Holiday", schema="Schedule")
@XmlAccessorType(XmlAccessType.NONE)
public class Holiday {

    @Id
    @GeneratedValue
    private Integer id;

    @XmlValue
    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
