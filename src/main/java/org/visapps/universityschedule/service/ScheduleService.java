package org.visapps.universityschedule.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Service;
import org.visapps.universityschedule.dto.Study;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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

    public List<Study> getStudies(Integer classId, Integer subclass) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2019-02-26");
        MongoCollection scheds = mongoTemplate.getCollection("scheds");
        List<Document> pipeline = Arrays.asList(new Document("$project",
                        new Document("day", 1)
                                .append("_id", 0)
                                .append("hour", 1)
                                .append("group", 1)
                                .append("loadId", 1)
                                .append("roomId", 1)
                                .append("beginDate",
                                        new Document("$dateFromString",
                                                new Document("dateString", "$beginDate")
                                                        .append("format", "%d.%m.%Y")))
                                .append("endDate",
                                        new Document("$dateFromString",
                                                new Document("dateString", "$endDate")
                                                        .append("format", "%d.%m.%Y")))),
                new Document("$match",
                        new Document("beginDate",
                                new Document("$lte", date))
                                .append("endDate",
                                        new Document("$gte", date))
                                .append("day", 2)),
                new Document("$lookup",
                        new Document("from", "loads")
                                .append("localField", "loadId")
                                .append("foreignField", "_id")
                                .append("as", "load")),
                new Document("$unwind",
                        new Document("path", "$load")),
                new Document("$addFields",
                        new Document("subclass",
                                new Document("$cond", Arrays.asList(new Document("$gt", Arrays.asList(new Document("$size", "$load.groups"), 1)), "$group", -1)))),
                new Document("$match",
                        new Document("load.klassIdList", 57)
                                .append("$or", Arrays.asList(new Document("load.groups",
                                                new Document("$size", 1)),
                                        new Document("group", 0)))),
                new Document("$unwind",
                        new Document("path", "$load.groups")
                                .append("includeArrayIndex", "groupid")),
                new Document("$match",
                        new Document("$expr",
                                new Document("$eq", Arrays.asList("$group", "$groupid")))
                                .append("load.groups.hourPerWeekList.4",
                                        new Document("$gt", 0))),
                new Document("$lookup",
                        new Document("from", "times")
                                .append("localField", "hour")
                                .append("foreignField", "_id")
                                .append("as", "time")),
                new Document("$unwind",
                        new Document("path", "$time")),
                new Document("$lookup",
                        new Document("from", "rooms")
                                .append("localField", "roomId")
                                .append("foreignField", "_id")
                                .append("as", "room")),
                new Document("$unwind",
                        new Document("path", "$room")),
                new Document("$lookup",
                        new Document("from", "teachers")
                                .append("localField", "load.groups.teacherId")
                                .append("foreignField", "person._id")
                                .append("as", "teacher")),
                new Document("$unwind",
                        new Document("path", "$teacher")),
                new Document("$lookup",
                        new Document("from", "subjects")
                                .append("localField", "load.groups.subjectId")
                                .append("foreignField", "_id")
                                .append("as", "subject")),
                new Document("$unwind",
                        new Document("path", "$subject")),
                new Document("$lookup",
                        new Document("from", "study_types")
                                .append("localField", "load.groups.studyTypeId")
                                .append("foreignField", "_id")
                                .append("as", "study_type")),
                new Document("$unwind",
                        new Document("path", "$study_type")),
                new Document("$project",
                        new Document("hour", 1)
                                .append("time", "$time.value")
                                .append("room", "$room.name")
                                .append("building", "$room.building")
                                .append("subject", "$subject.fullName")
                                .append("study_type", "$study_type.fullName")
                                .append("subclass", "$subclass")
                                .append("teacher",
                                        new Document("$concat", Arrays.asList("$teacher.person.surname", " ", "$teacher.person.firstName", ".", "$teacher.person.secondName", ".")))));
        List<Study> results = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        AggregateIterable<Document> aggregate = scheds.aggregate(pipeline);
        for(Document document : aggregate){
            logger.info("oops" + document.toJson());
            results.add(mapper.readValue(document.toJson(), Study.class));
        }
        return results;
    }

}
