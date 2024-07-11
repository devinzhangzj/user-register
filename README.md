
## Getting Started
I recorded a short video, Demo.mp4, demonstrating the project's structure and operation. 
Here is the demo video: 
https://drive.google.com/file/d/1Jwdl8QP9AisZuFei_U-KTaYsGLda4glo/view?usp=drive_link
Please set the video quality to 720p for better viewing by clicking the right corner setting.

Based on the Mac system:

1. Install PostgreSQL locally:
   - Install: `brew install postgresql@12`
   - Start the service: `brew services start postgresql@12`
   - Check the version: `psql --version`
   - Enter: `psql postgres`
   - Create a role and password, and set permissions:
     ```
     CREATE USER postgres WITH PASSWORD 'root';
     ALTER USER postgres WITH CREATEDB; 
     ALTER USER postgres WITH SUPERUSER; 
     ```

2. Install Docker and start Docker (details omitted)

3. Run the project:
   - In the project root directory, run: `./build.sh`

## API Endpoints

### User Service
- `POST /api/users/register`: Register a new user
- `GET /api/users/{id}`: Get a user by ID
- `GET /api/users`: Get all users
- `PUT /api/users/{id}`: Update a user
- `DELETE /api/users/{id}`: Soft delete a user

### Email Service
- `POST /api/emails/send`: Send a welcome email

## Project Structure
````
user-register/
|-- consul-server/
|   |-- src/
|       |-- main/
|           |-- java/
|               |-- com.example.consulserver/
|                   |-- ConsulServerApplication.java
|           |-- resources/
|               |-- application.properties
|   |-- Dockerfile
|-- user-service/
|   |-- src/
|       |-- main/
|           |-- java/
|               |-- com.example.userservice/
|                   |-- UserServiceApplication.java
|                   |-- config/
|                       |-- SwaggerConfig.java
|                   |-- controller/
|                       |-- UserController.java
|                   |-- dto/
|                       |-- UserDTO.java
|                   |-- exception/
|                       |-- GlobalExceptionHandler.java
|                   |-- model/
|                       |-- User.java
|                   |-- repository/
|                       |-- UserRepository.java
|                   |-- service/
|                       |-- UserService.java
|                       |-- UserServiceImpl.java
|           |-- resources/
|               |-- application.properties
|       |-- test/
|           |-- java/
|               |-- com.example.userservice/
|                   |-- service/
|                       |-- UserServiceTest.java
|                   |-- benchmark/
|                       |-- UserServiceBenchmark.java
|   |-- Dockerfile
|-- email-service/
|   |-- src/
|       |-- main/
|           |-- java/
|               |-- com.example.emailservice/
|                   |-- EmailServiceApplication.java
|                   |-- config/
|                       |-- SwaggerConfig.java
|                   |-- controller/
|                       |-- EmailController.java
|                   |-- service/
|                       |-- EmailService.java
|                       |-- EmailServiceImpl.java
|           |-- resources/
|               |-- application.properties
|       |-- test/
|           |-- java/
|               |-- com.example.emailservice/
|                   |-- service/
|                       |-- EmailServiceTest.java
|   |-- Dockerfile
|-- gateway-service/
|   |-- src/
|       |-- main/
|           |-- java/
|               |-- com.example.gatewayservice/
|                   |-- GatewayServiceApplication.java
|                   |-- config/
|                       |-- SwaggerConfig.java
|           |-- resources/
|               |-- application.properties
|   |-- Dockerfile
|-- frontend/
|   |-- src/
|       |-- App.js
|       |-- App.css
|       |-- index.js         
|       |-- index.js
|       |-- components/
|           |-- UserList.js
|           |-- UserForm.js
|   |-- Dockerfile
|-- db-init/
|   |-- init.sql
|-- docker-compose.yml
|-- README.md
|-- build.sh