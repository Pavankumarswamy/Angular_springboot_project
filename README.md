# Angular & Spring Boot Project

This repository contains a full-stack web application with a Spring Boot backend and an Angular frontend.

## Project Structure

- **backend** (Project "Certo"): A Spring Boot application (Java 17) serving as the REST API for user management and authentication.
- **frontend** (Project "Prime"): An Angular (v16) application providing the user interface.

## Features

- **User Authentication**: Login and Registration functionality.
- **User Management**: Fetch and display user details.
- **Layered Architecture**: Controller, Service, and Repository layers in the backend.
- **Interactive UI**: Angular components for a responsive user experience.

## Prerequisites

- **Java**: JDK 17 or later
- **Node.js**: LTS version recommended
- **Angular CLI**: Version 16+
- **Database**: MySQL Server

## Getting Started

### Backend Setup

1. Navigate to the backend directory:
   ```bash
   cd backend
   ```
2. Configure database credentials in `src/main/resources/application.properties`.
3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
   The backend will start on `http://localhost:8081`.

### Frontend Setup

1. Navigate to the frontend directory:
   ```bash
   cd frontend
   ```
2. Install dependencies:
   ```bash
   npm install
   ```
3. Start the development server:
   ```bash
   ng serve
   ```
   Navigate to `http://localhost:4200/`.

## detailed Logic

### Backend (Certo)
The backend uses Spring Data JPA, Hibernate, and Lombok. It exposes endpoints like `/api/v1/login` (POST) and `/api/v1/users` (GET).

### Frontend (Prime)
The frontend is generated with Angular CLI and includes components for login, signup, and user display.

---
*Created for Angular_springboot_project*
