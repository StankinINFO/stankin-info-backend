package org.visapps.universityschedule.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.visapps.universityschedule.dto.Class;
import org.visapps.universityschedule.dto.Study;
import org.visapps.universityschedule.util.MongoUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class UniversityService {

    private Logger logger = Logger.getLogger(ScheduleService.class.getName());

    private final MongoTemplate mongoTemplate;

    @Autowired
    public UniversityService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Class> getClasses(String query) throws Exception{
        MongoCollection classes = mongoTemplate.getCollection("classes");
        List<Document> pipeline = MongoUtil.classesPipeline(query);
        List<Class> results = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        AggregateIterable aggregate = classes.aggregate(pipeline);
        for(Object object : aggregate){
            Document document = (Document) object;
            results.add(mapper.readValue(document.toJson(), Class.class));
        }
        return results;
    }

}
