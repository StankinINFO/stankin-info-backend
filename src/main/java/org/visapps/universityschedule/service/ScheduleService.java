package org.visapps.universityschedule.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.visapps.universityschedule.dto.Study;
import org.visapps.universityschedule.entity.Term;
import org.visapps.universityschedule.util.MongoUtil;
import org.visapps.universityschedule.util.TimeUtil;

import java.util.*;
import java.util.logging.Logger;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class ScheduleService {

    private Logger logger = Logger.getLogger(ScheduleService.class.getName());

    private final MongoTemplate mongoTemplate;

    @Autowired
    public ScheduleService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Study> getStudies(Integer classId, Integer subclass, Date date) throws Exception {
        MongoCollection schedules = mongoTemplate.getCollection("scheds");
        Term beginDate = mongoTemplate.findOne(query(where("_id").is("beginDate")), Term.class);
        Date start = TimeUtil.DateFromString(beginDate != null ? beginDate.getValue() : null);
        Date current = TimeUtil.DateWithDefaultTime(date);
        Integer dayOfWeek = TimeUtil.DayOfWeek(date);
        String week = TimeUtil.WeekOfPeriod(start, date);
        List<Document> pipeline = MongoUtil.classDaySchedulePipeline(classId, subclass, current, dayOfWeek, week);
        List<Study> results = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        AggregateIterable aggregate = schedules.aggregate(pipeline);
        for(Object object : aggregate){
            Document document = (Document) object;
            results.add(mapper.readValue(document.toJson(), Study.class));
        }
        return results;
    }

}
