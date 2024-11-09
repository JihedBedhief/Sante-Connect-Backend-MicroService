FROM openjdk:17-jdk-slim
VOLUME /tmp
ARG JAR_FILE=target/Rendez-vous-MicroService-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8091
ENTRYPOINT ["java", "-jar", "/app.jar"]
