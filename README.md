# Login and Signup Backend API with Security and JWT Tokens

This project is a backend implementation of a login and signup REST API with security and JWT tokens. It is built using Java, Spring Boot, Spring MVC, Spring Security and utilizes H2 database for data storage. The API endpoints provided below demonstrate the functionality of the application.

## Installation and Setup

```
### Prerequisites
- Java Development Kit (JDK) 8 or later
- Maven
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
- Path: `http://localhost:8080/app/signup`
- Description: Register a new user.
- Request Body: User data in the JSON format (e.g., name, email, password).

```

{
  "fullName": "Shubham Verma",
  "password": "234$hubham",
  "email": "verma@gmail.com"
}
```

- Response:

```
{
    "id": 1,
    "fullname": "Shubham Verma,
    "password": "$2a$10$fpDvvfUltDIv9nTl.jzqv.TdfGmQYbVQuGNjJVHT83fGW6PCBVvK.",
    "email": "verma@gmail.com",
    "role": "ROLE_USER"
}

```

### User Login

- Method: GET
- Path: `http://localhost:8080/signIn`
- Description: Authenticate a user and retrieve their details.
- Authentication: Basic Authentication (Username and Password)
    - Username: [verma@gmail.com](mailto:verma@gmail.com)
    - Password: 234$hubham
- Response:

```
{
    "id": 1,
    "fullname": "Shubham Verma,
    "password": "$2a$10$fpDvvfUltDIv9nTl.jzqv.TdfGmQYbVQuGNjJVHT83fGW6PCBVvK.",
    "email": "verma@gmail.com",
    "role": "ROLE_USER"
}

```

### Welcome Endpoint (Requires Authentication)

- Method: GET
- Path: `http://localhost:8080/logged-in/user`
- Description: A protected endpoint that requires authentication to access.
- Authentication: Bearer Token
- Request Header:
    - Authorization: Bearer <token>
- Response: A welcome message string.
- Example:
    - Bearer Token: eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJTaGltYmh1Iiwic3ViIjoiSldUIFRva2VuIiwidXNlcm5hbWUiOiJza0BnbWFpbC5jb20iLCJyb2xlIjoiUk9MRV9VU0VSIiwiaWF0IjoxNjg1Njc3Mzg3LCJleHAiOjE2ODU3MDczODd9.VwM2IGD1fABjEcnNoMb4uIyBnYe3_BmZGx33dElaD-E
    - Response: Welcome to Shubham's Website: Shubham Verma

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
    - Minimum length: 3 characters
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

The project can be imported and run using an IDE like Eclipse.

### Test API

You can use Postman to test the API endpoints.

## H2 Database Configuration

The project uses the H2 in-memory database by default.

The application is configured to use the H2 database. The configuration can be found in the `application.properties` file:

```
# Server Port Configuration
server.port=8081

# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

```

## **Contributors**

- **[Shubham Verma](https://github.com/Verma35Shubham)**
 
