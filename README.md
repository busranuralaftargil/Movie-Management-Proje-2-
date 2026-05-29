# Movie Management System API (Version 2)

## Overview

Movie Management System API is a RESTful web application developed using Java 25 and Spring Boot 4. The project is designed to manage movies, actors, and their relationships through a scalable layered architecture following modern software engineering principles.

This project is the second version of the Movie Management System and extends the first version by introducing REST API endpoints, DTO-based data transfer, exception handling, logging mechanisms, Swagger documentation, and database persistence.

---

## Features

### Movie Management

* Create new movies
* Update movie information
* Delete movies
* Retrieve all movies
* Retrieve movie details by ID

### Actor Management

* Create new actors
* Update actor information
* Delete actors
* Retrieve all actors
* Retrieve actor details by ID

### Relationship Management

* Associate actors with movies
* Retrieve actors of a movie
* Retrieve movies of an actor

### API Documentation

* Swagger / OpenAPI integration
* Interactive API testing interface

### Logging & Error Handling

* Global exception handling
* Request validation
* Custom error responses
* Application activity logging

---

## Architecture

The application follows a layered architecture:

Controller Layer
→ Handles HTTP requests and responses

Service Layer
→ Contains business logic

Repository Layer
→ Handles database operations

Database Layer
→ MySQL / PostgreSQL

DTO Layer
→ Transfers data between API and client

---

## Technologies Used

* Java 25
* Spring Boot 4
* Spring Data JPA
* Spring Web
* Spring Validation
* Maven
* MySQL / PostgreSQL
* Swagger OpenAPI
* Lombok
* Hibernate

---

## API Endpoints

### Movie Endpoints

* GET /movies
* GET /movies/{id}
* POST /movies
* PUT /movies/{id}
* DELETE /movies/{id}

### Actor Endpoints

* GET /actors
* GET /actors/{id}
* POST /actors
* PUT /actors/{id}
* DELETE /actors/{id}

---

## Project Objectives

* Implement RESTful API principles
* Use DTO-based communication
* Apply repository-service architecture
* Provide comprehensive API documentation
* Ensure proper exception handling
* Maintain application logs
* Demonstrate CRUD operations using a relational database

---

## Author

**Büşranur Alaftargil**

Software Engineering Student
Sakarya University

---

## Version

Current Version: **2.0**
