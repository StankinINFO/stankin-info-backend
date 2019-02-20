package org.visapps.universityschedule.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MongoConfiguration extends AbstractMongoConfiguration {

    @Value( "${schedule.database.connection}" )
    private String connection;

    @Override
    protected String getDatabaseName() {
        return "schedule";
    }

    @Override
    public MongoClient mongoClient() {
        MongoClientURI uri = new MongoClientURI(connection);
        return new MongoClient(uri);
    }
}
