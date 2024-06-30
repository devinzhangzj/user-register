#!/bin/bash

# Build the Spring Boot application
./mvnw clean package

# Build and run the Docker containers
docker-compose up --build
