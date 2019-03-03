package org.visapps.universityschedule.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Class {

    private Integer id;
    private String name;
    private Integer students;
    private String speciality;
    private Integer semester;

}
