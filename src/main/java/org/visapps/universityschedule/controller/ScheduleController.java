package org.visapps.universityschedule.controller;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.visapps.universityschedule.dto.Study;
import org.visapps.universityschedule.service.ScheduleService;

import java.util.List;

@RestController
@RequestMapping("api/v1/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/class")
    public List<Study> getClassSchedule() {
        try{
            return scheduleService.getStudies(0,0);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
