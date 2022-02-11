FROM openjdk:8u242-jre-slim
MAINTAINER Amr Ali Eissa "amrali.easa@gmail.com"
COPY ./target/exercise-0.0.1-SNAPSHOT.jar ./app.jar
COPY ./target/classes/application.properties ./application.properties
ENTRYPOINT ["java","-jar", "-Dspring.config.location=/application.properties", "app.jar"]
EXPOSE 8080