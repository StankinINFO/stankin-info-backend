package org.visapps.universityschedule.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MongoConfiguration extends AbstractMongoConfiguration {

    @Value( "${schedule.database.url}" )
    private String url;

    @Value( "${schedule.database.name}" )
    private String name;

    @Bean
    MongoTransactionManager transactionManager(MongoDbFactory dbFactory) {
        return new MongoTransactionManager(dbFactory);
    }

    @Override
    protected String getDatabaseName() {
        return name;
    }

    @Override
    public MongoClient mongoClient() {
        MongoClientURI uri = new MongoClientURI(url);
        return new MongoClient(uri);
    }
}
