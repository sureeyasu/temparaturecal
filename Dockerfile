FROM openjdk:8
MAINTAINER suresh
EXPOSE 8085
ARG JAR_FILE=target/temparaturecal-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]