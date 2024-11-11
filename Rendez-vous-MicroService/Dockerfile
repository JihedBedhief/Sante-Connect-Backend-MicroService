# Use an official Maven image to build the application
FROM maven:3.8.5-openjdk-17 AS builder

# Set working directory inside the container
WORKDIR /app

# Copy the pom.xml and dependencies
COPY pom.xml ./
RUN mvn dependency:go-offline

# Copy the project source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Use a smaller JDK image for running the application
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy the built jar from the previous step
COPY --from=builder /app/target/Rendez-vous-MicroService-0.0.1-SNAPSHOT.jar app.jar

# Expose the application's port
EXPOSE 8091



# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]