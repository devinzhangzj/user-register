#!/bin/bash

# Build the Spring Boot application
./mvnw clean package -DskipTests

# Build and run the Docker containers
docker-compose up --build
