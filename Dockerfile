FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY build/libs/universityschedule-0.0.1-SNAPSHOT.jar universityschedule-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar","/universityschedule-0.0.1-SNAPSHOT.jar"]