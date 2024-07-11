# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the executable JAR file
COPY target/email-service-0.0.1-SNAPSHOT.jar email-service.jar

# Expose the port the application runs on
EXPOSE 8082

# Run the JAR file
ENTRYPOINT ["java", "-jar", "email-service.jar"]
