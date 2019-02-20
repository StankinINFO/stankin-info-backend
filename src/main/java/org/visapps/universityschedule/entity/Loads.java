package org.visapps.universityschedule.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Loads {

    private String bload;
    @XmlElement(name="load")
    private List<Load> loads;

    public String getBload() {
        return bload;
    }

    public void setBload(String bload) {
        this.bload = bload;
    }

    public List<Load> getLoads() {
        return loads;
    }

    public void setLoads(List<Load> loads) {
        this.loads = loads;
    }
}
