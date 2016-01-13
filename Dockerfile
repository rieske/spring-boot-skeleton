FROM webdizz/centos-java8

EXPOSE 8080 8081
ADD build/libs/*.jar /opt/service/service.jar
WORKDIR /opt/service

ENTRYPOINT ["java", "-jar", "service.jar"]