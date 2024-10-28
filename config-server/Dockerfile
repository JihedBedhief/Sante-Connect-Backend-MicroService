FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/config-server-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8888

ENV SPRING_PROFILES_ACTIVE=native,docker

# Add curl for healthcheck
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*

CMD ["java", "-jar", "app.jar"]