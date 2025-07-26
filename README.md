# Translation  Service – DigitalTolk Code Test

This project is a Spring Boot implementation of a Translation Management API with JWT authentication, Swagger documentation, scalable seed data generation, and Docker support.

## Features

- Store translations in multiple locales (`en`, `fr`, `es`)
- Add contextual tags to translations (e.g., `mobile`, `desktop`)
- CRUD + search endpoints
- Export translations as JSON
- Secure API with JWT
- Docker support
- Swagger API docs
- Populate 100k+ records on startup

## Getting Started

### Prerequisites

- Docker
- Maven

### Run with Docker

```bash
docker-compose up --build
