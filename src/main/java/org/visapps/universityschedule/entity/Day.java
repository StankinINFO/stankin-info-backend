package org.visapps.universityschedule.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@Entity
@Table(name = "Day", schema="Schedule")
@XmlAccessorType(XmlAccessType.NONE)
public class Day {

    @Id
    @GeneratedValue
    private Integer id;

    @XmlValue
    private Integer value;
    @XmlAttribute(name = "i")
    private Integer i;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }
}
