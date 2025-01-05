# Blogging Platform API 🔖

## Description
This is a RESTful API built using Spring Boot to power a blogging platform. It allows users to create, manage, and interact with blog posts, comments, and user accounts.

## Prerequisites
- **Java Development Kit (JDK)** 23 or higher
- **Spring Boot** version 3.x or higher
- **MySQL Database**
- **Git** (for cloning the repository)

## Getting Started

### **1. Clone the Repository**
  ```bash
  git clone [https://github.com/your-username/Blogging-platform-API.git](https://github.com/nndasapalli/Blogging-platform-API.git)
  ```
### 2. Navigate to the Project Directory
```bash
cd Blogging-platform-API
```
### 3. Set Up the MySQL Database
•	Create a MySQL database named blogging_platform_db.
•	Update application.properties with your MySQL connection details:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/blogging_platform_db
spring.datasource.username=your-mysql-username
spring.datasource.password=your-mysql-password
```
### 4. Build and Run the Project
•	Run the Spring Boot application using:
 ```bash
./mvnw spring-boot:run
```
or for Windows:
```bash
mvnw.cmd spring-boot:run
```
### 5. Access the Application
•	The application will be running at:
```bash
http://localhost:8080
```

