package org.visapps.universityschedule.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Scheds {

    private String bload;
    @XmlElement(name="sched")
    private List<Sched> scheds;

    public String getBload() {
        return bload;
    }

    public void setBload(String bload) {
        this.bload = bload;
    }

    public List<Sched> getScheds() {
        return scheds;
    }

    public void setScheds(List<Sched> scheds) {
        this.scheds = scheds;
    }

}
