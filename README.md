# Login and Signup Backend API with Security and JWT Tokens

This project is a backend implementation of a login and signup REST API with security and JWT tokens. It is built using Java, Spring Boot, Spring MVC, Spring Security and utilizes H2 database for data storage. The API endpoints provided below demonstrate the functionality of the application.

## Installation and Setup

```
### Prerequisites
- Java Development Kit (JDK) 17 or later
- Maven
- JWT Filter & Validation
- Postman (for testing the API)
```

### 1. Clone the Repository

```
https://github.com/Verma35Shubham/GreenStitchBackendAssignment.git
```

### 2. Go the Project

```
cd GreenStich_Backend_Assignment/GreenStitch_Backend_Assignment

```

### 3. Run the Application
- For GitBash
```
./mvnw spring-boot:run

```
**The application will start running on [http://localhost:8080](http://localhost:8080)**

### **API Endpoints**

### User Signup

- Method: POST
- Path: `http://localhost:808/signup`
- Description: Register a new user.
- Request Body: User data in the JSON format (e.g., name, email, password).

```

{
  "name": "Shubham httthd",
  "email": "poa@gmail.com",
  "password": "234$Verma",
  "role":  "ADMIN"
}
```

- Response:

```
{
    "jwtToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwb2FAZ21haWwuY29tIiwiZXhwIjoxNjg3NjMxMjA1LCJpYXQiOjE2ODc2MTMyMDV9.B2tSUlq5hMfBKPt0C1evONoSUCMV37Hrh_s9RXuAhQEzfZ5F-Lmo4_hwjXNLYCCj5vMM5yuNtgWU2tp3kJvFAw",
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwb2FAZ21haWwuY29tIiwiZXhwIjoxNjg3NjMxMjA1LCJpYXQiOjE2ODc2MTMyMDV9.B2tSUlq5hMfBKPt0C1evONoSUCMV37Hrh_s9RXuAhQEzfZ5F-Lmo4_hwjXNLYCCj5vMM5yuNtgWU2tp3kJvFAw"
}

```

### User Login

- Method: Post
- Path: `http://localhost:8080/login`
- Description: Authenticate a user and retrieve their details.
- Authentication: Basic Authentication (Username and Password)
    - Username: [the@gmail.com](mailto:poa@gmail.com)
    - Password: 234$hubham
- Response:

```
{
    "jwtToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwb2FAZ21haWwuY29tIiwiZXhwIjoxNjg3NzEyMTU3LCJpYXQiOjE2ODc2OTQxNTd9.Q-dftqx3bWdvy0S8_aQ-SVSuhM6_VohGOA9INDusWBUYgbx7oVxqLM_LBVhwJZ0kTHbHwa_Al2-8x5nrP9ddSg",
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwb2FAZ21haWwuY29tIiwiZXhwIjoxNjg3NzEyMTU3LCJpYXQiOjE2ODc2OTQxNTd9.Q-dftqx3bWdvy0S8_aQ-SVSuhM6_VohGOA9INDusWBUYgbx7oVxqLM_LBVhwJZ0kTHbHwa_Al2-8x5nrP9ddSg"
}

```


### Tech Stack

- Java
- Spring Boot
- H2 Database
- Spring Security
- JWT Token
- Lombok
- Maven

### Validation Rules

The following validation rules are applied to the user entity:

- Full Name:
    - Minimum length: 6 characters
    - Maximum length: 20 characters
- Password:
    - At least 8 characters
    - Contains at least one digit
    - Contains at least one lowercase letter
    - Contains at least one uppercase letter
    - Contains at least one special character
- Email:
    - Valid email format

### Development

The project can be imported and run using an IDE like IntellIj.

### Test API

You can use Postman to test the API endpoints.

## H2 Database Configuration

The project uses the H2 in-memory database by default.

The application is configured to use the H2 database. The configuration can be found in the `application.properties` file:

```
# Server Port Configuration
server.port=8081

# H2 Database Configuration
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create
jwt.secret=GreenStitch

```

## **Contributors**

- **[Shubham Verma](https://github.com/Verma35Shubham)**
 
