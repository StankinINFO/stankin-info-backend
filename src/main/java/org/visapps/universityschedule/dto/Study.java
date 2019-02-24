package org.visapps.universityschedule.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Study {

    private Integer hour;
    private String time;
    private String room;
    private String subject;
    @JsonProperty("study_type")
    private String studyType;
    private Integer subclass;
    private String teacher;

}
