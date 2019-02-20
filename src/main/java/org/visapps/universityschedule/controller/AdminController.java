package org.visapps.universityschedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.visapps.universityschedule.service.ScheduleService;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {

    private final ScheduleService scheduleService;

    @Autowired
    public AdminController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/upload")
    public String uploadSchedule(@RequestParam("schedule") MultipartFile file) {
        try{
            scheduleService.saveSchedule(file);
            return "ok";
        }
        catch(Exception e){
            e.printStackTrace();
            return "failed to insert";
        }
    }

}
