package org.visapps.universityschedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.visapps.universityschedule.entity.Day;
import org.visapps.universityschedule.entity.Holiday;
import org.visapps.universityschedule.entity.Time;
import org.visapps.universityschedule.entity.Timetable;
import org.visapps.universityschedule.service.ScheduleService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedInputStream;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {

    @Autowired
    ScheduleService scheduleService;

    @PostMapping("/upload")
    public String uploadSchedule(@RequestParam("schedule") MultipartFile file) {
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(Timetable.class, Day.class, Time.class, Holiday.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Timetable timetable = (Timetable) unmarshaller.unmarshal(new BufferedInputStream(file.getInputStream()));
            scheduleService.saveTimes(timetable);
            return "ok";
        }
        catch(Exception e){
            e.printStackTrace();
            return "failed to insert";
        }
    }

}
