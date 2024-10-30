FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/*.jar config-server.jar
ENTRYPOINT ["java","-jar","config-server.jar"]