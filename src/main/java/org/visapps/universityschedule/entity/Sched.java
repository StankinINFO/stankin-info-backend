package org.visapps.universityschedule.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Document(collection = "scheds")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Sched {

    @Id
    private String id;

    private Integer day;
    private Integer hour;
    private Integer group;
    @XmlElement(name = "load_id")
    private Integer loadId;
    @XmlElement(name = "room_id")
    private Integer roomId;
    private String fixed;
    @XmlElement(name = "begin_date")
    private String beginDate;
    @XmlElement(name = "end_date")
    private String endDate;

}
