package org.visapps.universityschedule.service;

import org.bson.Document;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.visapps.universityschedule.entity.Teacher;
import org.visapps.universityschedule.entity.Timetable;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public ScheduleService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void saveSchedule(MultipartFile file) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Timetable.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Timetable timetable = (Timetable) unmarshaller.unmarshal(new BufferedInputStream(file.getInputStream()));
        mongoTemplate.insert(timetable.getTeachers(), "teachers");
    }

}
