package org.visapps.universityschedule.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.List;

@Entity
@Table(name = "Week", schema="Schedule")
@XmlAccessorType(XmlAccessType.FIELD)
public class Week {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Day> value;
    @XmlAttribute(name = "i")
    private Integer i;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Day> getValue() {
        return value;
    }

    public void setValue(List<Day> value) {
        this.value = value;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

}
