package org.visapps.universityschedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.visapps.universityschedule.dto.Response;
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
    @CrossOrigin
    public ResponseEntity<Response> classSchedule(@RequestParam(value="classId") Integer classId,
                                                  @RequestParam(value="subclass") Integer subclass,
                                                  @RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
        try{
            List<Study> results = scheduleService.getStudies(classId, subclass, date);
            return ResponseEntity.ok(Response.Success(results));
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(Response.Error());
        }
    }

    @GetMapping("/class/semestr")
    @CrossOrigin
    public ResponseEntity<Response> classScheduleSemestr(@RequestParam(value="classId") Integer classId,
                                                  @RequestParam(value="subclass") Integer subclass) {
        try{
            List<Study> results = scheduleService.getStudies(classId, subclass);
            return ResponseEntity.ok(Response.Success(results));
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(Response.Error());
        }
    }
}
