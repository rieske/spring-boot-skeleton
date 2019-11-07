FROM openjdk:11.0.5-jdk-slim

EXPOSE 8080 8081
WORKDIR /opt/service

ENTRYPOINT exec java --illegal-access=deny -Xms128m -Xmx128m -jar service.jar

ADD build/libs/skeleton.jar /opt/service/service.jar
