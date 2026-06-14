# Authify Server 🔐
Authify Server is a secure authentication and user management backend that implements modern authentication workflows using Spring Boot, Spring Security, JWT, PostgreSQL, and Brevo Email API. It enables user registration, login, email verification through OTP, password recovery, profile management, and secure access to protected resources through stateless authentication and industry-standard security practices.
## 🚀 Overview

Authify Server provides a robust authentication backend that enables users to:

* Register new accounts
* Receive welcome emails after registration
* Log in securely using email and password
* Verify their account using Email OTP
* Access protected resources using JWT authentication
* Reset forgotten passwords using Email OTP verification
* Manage user profiles
* Secure API endpoints using Spring Security

This project follows modern authentication practices and is designed to work seamlessly with frontend applications built using React, Angular, Vue, or any other client-side framework.

---

## 🛠️ Tech Stack

### Backend

* Java 21
* Spring Boot
* Spring Security
* Spring Data JPA
* JWT (JSON Web Token)
* Maven

### Database

* PostgreSQL

### Email Service

* Brevo Email API

### Deployment

* Render

---

## ✨ Features

### Authentication

* User Registration
* User Login
* JWT Token Generation
* JWT Validation
* HTTP-Only Cookie Authentication
* 24-Hour Session Management
* Secure Logout

### Email Services

* Welcome Email on Registration
* OTP-Based Email Verification
* OTP-Based Password Recovery
* Brevo Email API Integration

### Security

* Spring Security Integration
* BCrypt Password Hashing
* JWT Authentication
* Protected API Endpoints
* Stateless Authentication
* Secure HTTP-Only Cookies
* CORS Configuration

### User Management

* View User Profile
* Account Verification Status
* Secure Account Access

### Database

* PostgreSQL Integration
* JPA/Hibernate ORM
* Automatic Entity Mapping

---

## 📂 Project Structure

```text
src
├── main
│   ├── java
│   │   └── com.example.authify
│   │       ├── config
│   │       ├── controller
│   │       ├── dto
│   │       ├── entity
│   │       ├── filter
│   │       ├── io
│   │       ├── repository
│   │       ├── service
│   │       ├── util
│   │       └── AuthifyApplication.java
│   └── resources
│       └── application.properties
```

---

## 🔑 Authentication & Verification Flow

### 1. User Registration

1. User registers using name, email, and password.
2. Password is encrypted using BCrypt before being stored.
3. User profile is created successfully.
4. A welcome email is sent to the user's email address using Brevo Email API.

### 2. User Login

1. User logs in using email and password.
2. Spring Security validates the credentials.
3. JWT token is generated.
4. JWT token is returned to the client.
5. JWT is stored in a secure HTTP-Only cookie.
6. Cookie remains valid for 24 hours.
7. User gains access to authenticated features.

### 3. Email Verification

1. Authenticated user requests an Email Verification OTP.
2. System generates an OTP.
3. OTP is sent to the registered email address.
4. User submits the received OTP.
5. OTP is validated.
6. User account is marked as verified.

### 4. Access Protected Resources

1. Client sends authenticated requests.
2. JWT token is validated by Spring Security filters.
3. User identity is extracted from the token.
4. Authorized users can access protected endpoints.

### 5. Forgot Password

1. User requests a password reset.
2. System generates a reset OTP.
3. OTP is sent to the registered email address.
4. User submits email, OTP, and new password.
5. OTP is validated.
6. Password is encrypted using BCrypt.
7. Password is updated successfully.

---

## 📡 API Endpoints

### Authentication

#### Register User

```http
POST /api/v1.0/register
```

Creates a new user account and sends a welcome email.

---

#### Login User

```http
POST /api/v1.0/login
```

Authenticates the user and generates a JWT token.

---

#### Logout User

```http
POST /api/v1.0/logout
```

Clears the authentication cookie and logs out the user.

---

### User

#### Get Profile

```http
GET /api/v1.0/profile
```

Returns the authenticated user's profile information.

---

#### Check Authentication Status

```http
GET /api/v1.0/is-authenticated
```

Returns whether the current user is authenticated.

---

### Email Verification

#### Send Verification OTP

```http
POST /api/v1.0/send-otp
```

Generates and sends an Email Verification OTP to the authenticated user.

---

#### Verify Email OTP

```http
POST /api/v1.0/verify-otp
```

Validates the OTP and marks the account as verified.

---

### Password Recovery

#### Send Reset OTP

```http
POST /api/v1.0/send-reset-otp?email=user@example.com
```

Generates and sends a password reset OTP.

---

#### Reset Password

```http
POST /api/v1.0/reset-password
```

Validates the OTP and updates the user's password.

---

## ⚙️ Environment Variables

Configure the following environment variables before deployment:

```env
DATASOURCE_URL=your_postgresql_database_url
DATASOURCE_USER=your_database_username
DATASOURCE_PASSWORD=your_database_password

JWT_SECRET=your_jwt_secret_key

BREVO_API_KEY=your_brevo_api_key

SENDER_EMAIL=your_sender_email

FRONTEND_URL=https://your-frontend-domain.com
```

---

## 🗄️ Database Configuration

Example PostgreSQL configuration:

```properties
spring.datasource.url=${DATASOURCE_URL}
spring.datasource.username=${DATASOURCE_USER}
spring.datasource.password=${DATASOURCE_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## ▶️ Running Locally

### Clone Repository

```bash
git clone https://github.com/your-username/authify-server.git
```

### Navigate to Project

```bash
cd authify-server
```

### Configure Environment Variables

Set up PostgreSQL credentials, JWT secret, and Brevo API credentials.

### Run Application

```bash
mvn spring-boot:run
```

The application will start on:

```text
http://localhost:8080/api/v1.0
```

---

## 🔒 Security Features

* BCrypt Password Hashing
* JWT-Based Authentication
* Secure HTTP-Only Cookies
* 24-Hour Authentication Session
* Spring Security Authorization Filters
* Protected API Endpoints
* Email OTP Verification
* Password Recovery via OTP
* CORS Protection
* Stateless Session Management

---

## 🌐 Deployment

The backend is deployed on Render and can be connected with any frontend application.

### Deployment Considerations

* Configure PostgreSQL database credentials.
* Configure JWT secret securely.
* Configure Brevo API credentials.
* Configure frontend origin in CORS settings.
* Use HTTPS in production.
* Secure all sensitive environment variables.

---

## 🧪 Future Enhancements

* OAuth2 Login (Google/GitHub)
* Refresh Token Support
* Multi-Factor Authentication (MFA)
* Role-Based Access Control (RBAC)
* Account Activity Logs
* Device Management
* Login Notifications

---

## 👨‍💻 Author

Amit Vishwakarma

- B.Tech Computer Engineering Student
- Full-Stack Developer
- Passionate about Backend Development, System Design, and Secure Web Applications
