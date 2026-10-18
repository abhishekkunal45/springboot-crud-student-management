Student Management System - Spring Boot CRUD API

Overview
This is a RESTful CRUD application built using Spring Boot. It provides APIs to manage student records, including creating, reading, updating, and deleting students.

Technologies Used
Java 21
Spring Boot
Spring Data JPA
Maven
REST API
MySQL
IntelliJ IDEA
Git & GitHub
Project Structure
Controller
│
Service
│
Repository
│
Entity
│
Database

Features:
Create a Student
Get Student by ID
Get All Students
Update Student Information
Delete Student

API Endpoints:
Create Student
POST /students
Get All Students
GET /students
Get Student By ID
GET /students/{id}
Update Student
PUT /students/{id}
Delete Student
DELETE /students/{id}
Database Configuration
Configure your MySQL database in:

src/main/resources/application.properties
Example:

spring.datasource.url=jdbc:mysql://localhost:3306/studentdb
spring.datasource.username=root
spring.datasource.password=your_password
Running the Application
Clone the repository
git clone https://github.com/YOUR_USERNAME/crudSpringBootdemo.git
Navigate to the project
cd crudSpringBootdemo
Run the application
mvn spring-boot:run
Learning Outcomes
This project helped me understand:

Spring Boot fundamentals
REST API development
Dependency Injection
Layered Architecture
Spring Data JPA
MySQL integration
Git and GitHub version control

Author
Abhishek Kunal Singh
M.Sc. Software Systems Engineering RWTH Aachen University
