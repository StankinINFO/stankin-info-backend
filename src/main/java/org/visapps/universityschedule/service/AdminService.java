package org.visapps.universityschedule.service;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.visapps.universityschedule.entity.Holiday;
import org.visapps.universityschedule.entity.Time;
import org.visapps.universityschedule.entity.Timetable;
import org.visapps.universityschedule.entity.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedInputStream;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class AdminService {

    private static final Logger logger = LoggerFactory.getLogger(AdminService.class);

    private String[] collections =
            {"areas", "chairs","classes","holidays","loads","plans","rooms",
                    "scheds","specialities","study_types","subjects","teachers","terms","times"};

    private final MongoTemplate mongoTemplate;

    @Autowired
    public AdminService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Transactional
    public void saveSchedule(MultipartFile file) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Timetable.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Timetable timetable = (Timetable) unmarshaller.unmarshal(new BufferedInputStream(file.getInputStream()));
        for(String collection : collections) {
            mongoTemplate.getCollection(collection).deleteMany(new Document());
        }
        AtomicInteger timeId = new AtomicInteger(0);
        AtomicInteger holidayId = new AtomicInteger(0);
        List<Time> times = timetable.getTimes();
        List<Holiday> holidays = timetable.getHolidays();
        times.forEach(time->time.setId(timeId.getAndIncrement()));
        holidays.forEach(holiday->holiday.setId(holidayId.getAndIncrement()));
        mongoTemplate.insert(times, "times");
        mongoTemplate.insert(holidays, "holidays");
        mongoTemplate.insert(timetable.getTerm().toList(), "terms");
        mongoTemplate.insert(timetable.getAreas(), "areas");
        mongoTemplate.insert(timetable.getChairs(), "chairs");
        mongoTemplate.insert(timetable.getClasses(), "classes");
        mongoTemplate.insert(timetable.getLoads().getLoads(), "loads");
        mongoTemplate.insert(timetable.getPlans(), "plans");
        mongoTemplate.insert(timetable.getRooms(), "rooms");
        mongoTemplate.insert(timetable.getScheds().getScheds(), "scheds");
        mongoTemplate.insert(timetable.getSpecialities(), "specialities");
        mongoTemplate.insert(timetable.getStudyTypes(), "study_types");
        mongoTemplate.insert(timetable.getSubjects(), "subjects");
        mongoTemplate.insert(timetable.getTeachers(), "teachers");
    }

}
