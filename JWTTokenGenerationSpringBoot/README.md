# JWT Token Generation - Spring Boot

This project accepts a JSON payload and creates a signed JWT using the HS256 algorithm.

## Requirements
- JDK 17 or later
- Spring Tool Suite (STS) / Eclipse with Spring support
- Maven
- Internet connection on the first build to download dependencies

## Import into Spring Tool Suite
1. Extract `JWTTokenGenerationSpringBoot.zip`.
2. Open Spring Tool Suite.
3. Select **File -> Import -> Maven -> Existing Maven Projects**.
4. Browse to the extracted `JWTTokenGenerationSpringBoot` folder.
5. Select `pom.xml`, then click **Finish**.
6. Wait for Maven dependencies to finish downloading.
7. Open `JwtTokenGenerationApplication.java`.
8. Right-click the file -> **Run As -> Spring Boot App**.

## Test using Postman
- Method: `POST`
- URL: `http://localhost:8080/api/jwt/generate`
- Header: `Content-Type: application/json`
- Body -> raw -> JSON:

```json
{
  "payload": {
    "sub": "student123",
    "role": "USER",
    "status": "ACTIVE"
  }
}
```

A successful response looks like:

```json
{
  "token": "<signed-jwt-token>",
  "tokenType": "Bearer",
  "expiresInSeconds": 3600
}
```

The generated token is signed, not encrypted. Do not put passwords or other secrets in the payload.

## Main program flow
1. `JwtController` receives the JSON request.
2. `JwtRequest` stores the payload.
3. `JwtService.generateToken()` adds issue and expiry times and signs the claims with the configured HS256 secret.
4. `JwtResponse` returns the token to the client.

## Important
The configured secret is for local demonstration only. In a real application, store a randomly generated secret of at least 32 bytes in an environment variable or secret manager. Do not commit production secrets to source control.

There is no repository/database layer because this task only generates a token and does not persist data.
