FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/*.jar discovery-server.jar
ENTRYPOINT ["java","-jar","discovery-server.jar"]