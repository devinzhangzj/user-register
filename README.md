
## Getting Started
I recorded a short video, Demo.mp4, demonstrating the project's structure and operation. 

Due to my busy work schedule and many family matters to handle over the weekends, 
I could only spend 3-4 hours on this project, leaving many parts incomplete. 

Please understand.

1. Install Consul (Mac OS)
   brew tap hashicorp/tap
   brew install hashicorp/tap/consul 

2. Check and start consul
   consul --version
   consul agent -dev

3. Clone the repository:
    ```sh
    git clone https://github.com/devinzhangzj/user-register.git
    cd user-register
    ```

4. Ensure the database is initialized:
   db-init/init.sql，create userdb in postgresql

5. Run all services in Spring boot env: gateway-service, user-service, email-service

6. Run the frontend service
    ```sh
    cd frontend
    npm install
    npm start
    ```

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
|-- db-init/
|   |-- init.sql
|-- docker-compose.yml
|-- README.md
|-- build.sh

```