package org.visapps.universityschedule.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.visapps.universityschedule.dto.Study;
import org.visapps.universityschedule.util.MongoUtil;
import org.visapps.universityschedule.util.TimeUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Service
public class ScheduleService {

    private Logger logger = Logger.getLogger(ScheduleService.class.getName());

    private final MongoTemplate mongoTemplate;

    @Autowired
    public ScheduleService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Study> getStudies(Integer classId, Integer subclass, Date date) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date start = format.parse("2019-02-04");
        MongoCollection scheds = mongoTemplate.getCollection("scheds");
        Integer dayOfWeek = TimeUtil.getDayOfWeek(date);
        String week = TimeUtil.getWeekOfPeriod(start, date);
        List<Document> pipeline = MongoUtil.getClassDaySchedulePipeline(classId, subclass, date, dayOfWeek, week);
        List<Study> results = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        AggregateIterable aggregate = scheds.aggregate(pipeline);
        for(Object object : aggregate){
            Document document = (Document) object;
            results.add(mapper.readValue(document.toJson(), Study.class));
        }
        return results;
    }

}
