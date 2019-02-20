package org.visapps.universityschedule.service;

import org.bson.Document;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ScheduleService {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public ScheduleService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void saveSchedule(MultipartFile file) throws Exception {
        String xml = new String(file.getBytes(), "windows-1251");
        JSONObject jsonObject = XML.toJSONObject(xml);
        String json = jsonObject.toString();
        Document doc = Document.parse(json);
        doc.put("_id","2019-01");
        mongoTemplate.insert(doc, "timetable");
    }

}
