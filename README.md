🌤️ SmartCity Hub – Weather Service

A full-stack weather application built with Java Spring Boot (Reactive) and Angular, containerized with Docker and served via NGINX.
This project consumes the OpenWeather API and is designed with clean architecture, scalability, and production readiness in mind.

📌 Project Overview

SmartCity Hub – Weather Service is part of a modular Smart City ecosystem.
It provides real-time weather information by city name, exposing a REST API and a modern frontend interface.

Key Goals

Reactive backend using Spring WebFlux

Clean separation of concerns (client, service, config, exceptions)

Secure handling of API keys

Dockerized full-stack application

Production-ready frontend served with NGINX

Easy local setup with Docker Compose

🧱 Tech Stack
Backend

Java 21

Spring Boot 3

Spring WebFlux

WebClient

Reactor

Jackson

Maven

Frontend

Angular (Standalone Components)

TypeScript

RxJS

Angular Forms & HttpClient

Infrastructure

Docker

Docker Compose

NGINX

OpenWeather API

📂 Project Structure
SmartCity-Hub/
│
├── weather-service/           # Spring Boot backend
│   ├── src/main/java
│   ├── Dockerfile
│   └── pom.xml
│
├── weather-frontend/          # Angular frontend
│   ├── src/
│   ├── Dockerfile
│   └── angular.json
│
├── docker-compose.yml
├── .gitignore
└── README.md

🌐 Application Flow

User enters a city name in the Angular UI

Angular calls the backend endpoint:

GET /api/weather/{city}


Spring Boot calls OpenWeather API using WebClient

Response is parsed and mapped to a DTO

Data is returned to the frontend

Angular displays the weather data

🔐 API Key Management (Important)

⚠️ Security Notice

The OpenWeather API key is required to run this application.

The API key is never hardcoded

It is injected via environment variables

This prevents accidental exposure in Git repositories

⚠️ This API key is exposed ONLY for application runtime usage.
As a developer, I am fully aware that API keys must never be committed to version control.

⚙️ Environment Configuration
Backend Environment Variable
OPENWEATHER_API_KEY=your_api_key_here


Spring Boot reads it via:

openweather.api.key=${OPENWEATHER_API_KEY}

🐳 Docker & Docker Compose
Backend Dockerfile (Spring Boot)

Multi-stage build

Maven build stage

Lightweight JRE runtime image

Frontend Dockerfile (Angular + NGINX)

Angular production build

Static files served by NGINX

No Angular dev server in production

▶️ How to Run the Project (Recommended)
Prerequisites

Docker

Docker Compose

1️⃣ Clone the repository
git clone https://github.com/your-username/SmartCity-Hub.git
cd SmartCity-Hub

2️⃣ Set the API key

Create an environment variable:

Windows (PowerShell)

$env:OPENWEATHER_API_KEY="your_api_key_here"


Linux / macOS

export OPENWEATHER_API_KEY=your_api_key_here

3️⃣ Build and run everything
docker-compose up --build

4️⃣ Access the application
Service	URL
Frontend (Angular + NGINX)	http://localhost

Backend API	http://localhost/api/weather/{city}

Example:

http://localhost/api/weather/Bogota

🔁 CORS Configuration

CORS is explicitly configured to allow frontend access:

.allowedOrigins("http://localhost")
.allowedMethods("GET")


This ensures secure communication between Angular and Spring Boot.

🧪 Testing

Unit tests are implemented for the service layer

Reactive behavior is validated

Tests are intentionally excluded from the Docker build (-DskipTests)

Can be enabled locally if needed

🧠 Design Decisions

Reactive stack chosen for scalability

WebClient instead of RestTemplate (deprecated)

Standalone Angular components for modern Angular architecture

NGINX used for production-grade frontend serving

Docker Compose simplifies orchestration

🚀 Future Improvements

Add CI/CD pipeline

Deploy to Railway / Render / Fly.io

Add HTTPS with reverse proxy

Implement caching

Improve UI styling

Add monitoring & logging

👨‍💻 Author

Daniel Leonardo López Valderrama
Software Developer
Java • Spring Boot • Angular • Docker
