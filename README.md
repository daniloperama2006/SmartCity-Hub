# 🌦️ SmartCity Hub – Weather Service

> A professional microservice developed using **Java 17** and **Spring Boot 3** as part of the **SmartCity Hub** ecosystem. This service consumes the public **OpenWeather API** and exposes its own reactive REST endpoint, following modern best practices and clean architecture principles.

---

## 🚀 Project Overview

**SmartCity Hub** is a portfolio-oriented initiative designed to simulate a real-world microservices ecosystem for smart city platforms.

The **Weather Service** is the first microservice in this ecosystem and its main goals are:

* Integrate with a real external API provider
* Expose a clean, maintainable REST API
* Apply **Clean Architecture** and separation of concerns
* Use **reactive programming** correctly and intentionally
* Serve as a solid, interview-ready portfolio project

---

## 🧠 Tech Stack

| Technology          | Version          |
| ------------------- | ---------------- |
| Java                | 17               |
| Spring Boot         | 3.2.x            |
| WebClient (WebFlux) | ✔                |
| Maven               | Wrapper included |
| OpenAPI / Swagger   | springdoc        |
| IDE                 | IntelliJ IDEA    |
| Version Control     | Git + GitHub     |

> ⚠️ **Important:** WebFlux is used **only as an HTTP client** (`WebClient`). The server layer runs on **Spring MVC (Tomcat)**.

---

## 🏗️ Architecture

The project follows a **layered architecture**, inspired by **Clean Architecture** principles:

```
com.smartcity.weather
│
├── controller   → REST API layer
├── service      → Business logic
├── client       → External API client (OpenWeather)
├── dto          → Data Transfer Objects
├── exception    → Domain and provider exceptions
├── config       → Application and WebClient configuration
└── WeatherServiceApplication
```

### Architecture Principles Applied

* Clear separation of responsibilities
* No direct HTTP calls from the service layer
* Reactive, non-blocking flows
* Low coupling and high cohesion
* Designed for scalability and future expansion

---

## 🌐 Exposed REST API

### Get weather by city

```
GET /api/weather/{city}
```

#### Example Request

```
GET /api/weather/Bogota
```

#### Successful Response (200 OK)

```json
{
  "city": "Bogotá",
  "temperature": 18.5,
  "humidity": 72,
  "description": "partly cloudy"
}
```

---

## 🔗 External API Integration

* **Provider:** OpenWeather
* **Protocol:** REST
* **Client:** Spring WebClient (reactive)

All communication with the external provider is encapsulated inside the `WeatherClient` class, ensuring a clean separation between infrastructure and business logic.

---

## ⚠️ Error Handling

The service gracefully handles common provider and HTTP errors, including:

* Invalid or missing API key
* City not found
* Too many requests (rate limiting)
* External provider failures (5xx errors)

Each case is mapped to a **domain-specific exception**, making the system easier to maintain and extend.

---

## 🔐 API Key Security

The OpenWeather API key:

* ❌ Is **never committed** to the repository
* ✔ Is injected via configuration files or environment variables

### Example configuration

```yaml
openweather:
  api:
    key: ${OPENWEATHER_API_KEY}
```

📌 **Security & Ethics Note**

> This API key is used strictly for educational and development purposes. As a developer, I am fully aware that **sensitive credentials must never be exposed in source code or public repositories**.

---

## 📦 Current Project Status

✔ Project builds successfully
✔ Reactive WebClient configured and working
✔ REST endpoint operational
✔ External API fully integrated
✔ Clean architecture established

---

## 🛣️ Roadmap / Next Steps

* [ ] Input validation using `@Valid`
* [ ] Full Swagger / OpenAPI documentation
* [ ] Global exception handling (`@ControllerAdvice`)
* [ ] Unit and integration tests
* [ ] Dockerization (Dockerfile & docker-compose)
* [ ] Basic security (API Gateway / authentication)
* [ ] Integration with additional SmartCity Hub microservices

---

## 👨‍💻 Author

**Daniel López**
Software Developer

📌 This project was developed for **educational, professional, and portfolio** purposes.

---

⭐ If you find this project interesting or useful, feel free to give it a star on GitHub!
