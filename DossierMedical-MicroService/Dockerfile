
# Use an official Maven image to build the application
FROM maven:3.8.5-openjdk-17 AS builder

# Exposer le port
EXPOSE 8092

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

# Copier le fichier JAR dans l'image Docker
COPY target/DossierMedical-MicroService-0.0.1-SNAPSHOT.jar Dossier.jar

# Commande de démarrage de l'application
ENTRYPOINT ["java", "-jar", "Dossier.jar"]



