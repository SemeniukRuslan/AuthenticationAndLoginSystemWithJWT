## AuthenticationAndRegistrationSystemWithJWT

This project provides a secure and robust user authentication, login and register system using JWT (JSON Web Tokens) in
a Java web application.
The project is built using Spring Boot and Spring Security.

### Technologies Used

- Java 8
- Spring Boot (with Spring Security, Spring Data JPA, Spring MVC, Spring AOP)
- jjwt
- SLF4j
- H2

### Getting Started

To get started with this project, you will need to have the following installed:

- Java Development Kit (JDK) version 8 or later
- Maven

Once you have Java and Maven installed, you can clone the repository and run the project using the following commands:

- git clone https://github.com/SemeniukRuslan/AuthenticationAndRegistrationSystemWithJWT
- cd AuthenticationAndRegistrationSystemWithJWT
- mvn spring-boot:run

This will start the application on port 8090. You can access it by visiting http://localhost:8090 in Postman.

### Features

This system registers and authorizes users with the help of the AuthorizationController controller.
The next time the controller methods are accessed, the MainController requires a valid token, while checking the role of
the participant,
and then grants access to the appropriate content.

Methods url actions:

- POST /api/auth/register - register new account
- POST /api/auth/login - login and authentication an account
- GET /api/main/all - retrieve public content
- GET /api/main/user - access User content
- GET /api/main/mod - access Moderator content
- GET /api/main/admin - access Admin content

### Validation

Before the operation registration the following conditions must be met:

* all fields should be present;
* username should be a positive length;
* password should be a positive length;
* email should be not empty and have a valid format;
* role must not be empty and contain "user"or "admin"or "mod"or all together.

Before the operation login the following conditions must be met:

* all fields should be present;
* username should be a positive length;
* password should be a positive length.

Before accessing the resources of the main controller:

* valid token;
* appropriate role to the content.

### Register a new User

To register a new user, send a POST request to the /api/auth/register endpoint with the following JSON payload:

```json
 {
  "username": "testUsername",
  "email": "testEmail@mail.ua",
  "password": "123456711",
  "role": [
    "admin"
  ]
}
```

### Login user

To log in to the application, send a POST request to the /api/auth/login endpoint with the following JSON payload:

```json
 {
  "username": "testUsername",
  "email": "testEmail@mail.ua"
}
```

If the login is successful, you should receive a response with a JWT token in the Authorization header.
This token can be used to access protected endpoints in the application.

```json
{
  "id": 1,
  "username": "testUsername",
  "email": "testEmail@mail.ua",
  "roles": [
    "ROLE_ADMIN"
  ],
  "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0MyIsImlhdCI6MTY4MTA4ODY0NiwiZXhwIjoxNjgxMDkyMjQ2fQ.4kxD5eNgW0VgwKTjKAUhaThJdHb4IkIsnpi3ni7oVS4QjGnkYzLRhVpDm1AIUKOwMvpS2rb9Gdm5WabydCxl_g",
  "typeToken": "Bearer"
}
```

### Access Protected Endpoint

To access a protected endpoint, send a GET request to the /api/main/admin endpoint with the JWT token in the
Authorization header:

```yaml
{ Authorization: Bearer your_jwt_token_here }
```

If the token is valid, you should receive a response with a message indicating that you have access to the protected
endpoint.
When an unauthorized user attempts to access a protected resource, the server will respond with a 401 Unauthorized
status code.
Additionally, the passwords are hashed using bcrypt to ensure secure storage.

### Future Plans

* create integration tests;
* create exception handler;
* update class to refresh expired JWT token.