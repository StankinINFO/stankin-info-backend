package org.visapps.universityschedule.util;

import org.bson.Document;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class MongoUtil {

    public static List<Document> classDaySchedulePipeline(Integer classId, Integer subclass, Date date, Integer dayOfWeek, String week) {
        return Arrays.asList(new Document("$project",
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
                                .append("day", dayOfWeek)),
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
                        new Document("load.klassIdList", classId)
                                .append("$or", Arrays.asList(new Document("load.groups",
                                                new Document("$size", 1)),
                                        new Document("group", subclass)))),
                new Document("$unwind",
                        new Document("path", "$load.groups")
                                .append("includeArrayIndex", "groupid")),
                new Document("$match",
                        new Document("$expr",
                                new Document("$eq", Arrays.asList("$group", "$groupid")))
                                .append("load.groups.hourPerWeekList." + week,
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
                                .append("subject", "$subject.fullName")
                                .append("study_type", "$study_type.fullName")
                                .append("subclass", "$subclass")
                                .append("teacher",
                                        new Document("$cond",
                                                new Document("if",
                                                        new Document("$eq", Arrays.asList("$teacher.person.surname", "=")))
                                                        .append("then", "")
                                                        .append("else",
                                                                new Document("$concat", Arrays.asList("$teacher.person.surname", " ", "$teacher.person.firstName", ".", "$teacher.person.secondName", ".")))))),
                new Document("$sort",
                        new Document("hour", 1L)));
    }

    public static List<Document> classesPipeline(String query) {
        return Arrays.asList(new Document("$match",
                        new Document("name", Pattern.compile(query))),
                new Document("$lookup",
                        new Document("from", "specialities")
                                .append("localField", "specialityId")
                                .append("foreignField", "_id")
                                .append("as", "speciality")),
                new Document("$unwind",
                        new Document("path", "$speciality")),
                new Document("$project",
                        new Document("_id", 0L)
                                .append("id", "$_id")
                                .append("name", "$name")
                                .append("students", "$student")
                                .append("speciality", "$speciality.fullName")
                                .append("semester", "$semester")));
    }
}
