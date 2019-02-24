package org.visapps.universityschedule.controller;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.visapps.universityschedule.dto.Study;
import org.visapps.universityschedule.service.ScheduleService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/class/daily")
    public List<Study> getClassSchedule(@RequestParam(value="classId") Integer classId,
                                        @RequestParam(value="subclass") Integer subclass,
                                        @RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
        try{
            return scheduleService.getStudies(classId,subclass,date);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
