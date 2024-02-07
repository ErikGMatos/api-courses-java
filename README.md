# Courses API - CRUD Project

This is a Java-based API project utilizing the Spring Boot framework to perform CRUD (Create, Read, Update, Delete) operations on courses. The application also incorporates security features, Swagger documentation, Prometheus monitoring, and leverages Docker for simplified development and deployment environments.

## Technologies Used

- **Java:** A robust and versatile programming language chosen for the backend development of the application.
- **Spring Boot:** A framework that streamlines Java application development by providing default configurations for Spring-based applications.
- **PostgreSQL:** A relational database used to store and manage data related to courses.
- **Docker:** A platform enabling the packaging, distribution, and execution of applications in containers, ensuring a consistent environment for development and deployment.
- **Java JWT:** A library for implementing JSON Web Tokens (JWT) in Java, used for authentication in the API.
- **Security:** The Spring Security module to protect the application against threats and ensure proper authentication and authorization.
- **Swagger:** A documentation tool that automatically generates interactive documentation for APIs, making it easier to understand and use the API.
- **Lombok:** A library that simplifies Java code writing by eliminating the need to write getters, setters, and other repetitive methods.
- **Java Validation:** The Java Validation module allowing the definition of validation rules for data received by the API.
- **JUnit:** A Java testing framework used to write unit tests and ensure the robustness and reliability of the application.
- **Prometheus:** A monitoring and alerting system that collects metrics and events from systems, enabling the analysis of the application's performance.

## How to Run the Project

1. Clone the repository.
2. Ensure Docker is installed on your machine.
3. Run the command `docker-compose up` to start the application, database, and other services.

## API Documentation

The API documentation is available through Swagger. After starting the application, access [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) in your browser to explore endpoints and their descriptions.

## Unit Testing

Unit tests can be executed using JUnit. Run the tests to ensure the integrity of the application.

## Monitoring

Prometheus is configured to collect metrics from the application. Visit [http://localhost:9090](http://localhost:9090) to view metrics and monitor the API's performance.

This project provides a comprehensive solution for course management, from creation to removal, with a focus on security, documentation, and monitoring.
