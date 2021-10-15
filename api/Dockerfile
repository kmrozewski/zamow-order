FROM openjdk:11-jdk-slim-buster
VOLUME /tmp
COPY build/libs/api-*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
