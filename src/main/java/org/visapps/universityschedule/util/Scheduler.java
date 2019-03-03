package org.visapps.universityschedule.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.net.HttpURLConnection;
import java.net.URL;

@Configuration
@EnableScheduling
public class Scheduler {

    private static final Logger logger = LoggerFactory.getLogger(Scheduler.class);

    @Scheduled(fixedRate = 300000)
    public void pingItself() {
        try{
            HttpURLConnection httpUrlConnection = (HttpURLConnection) new URL(
                    "https://stankinschedule.herokuapp.com").openConnection();
            httpUrlConnection.setRequestMethod("HEAD");
            int responseCode = httpUrlConnection.getResponseCode();
            logger.info("Successfully pinged itself, response code: {}", responseCode);
        }
        catch(Exception e) {
            logger.error("Unable to ping itself");
        }
    }
}
