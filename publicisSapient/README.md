# Recipe API

## Overview
This project provides a RESTful API to manage recipes. It supports operations such as saving recipes, searching for recipes by keywords, and retrieving specific recipes by their ID. The data is stored in an in-memory H2 database. The API is developed using Spring Boot and follows REST standards.

## Features
- **Save Recipes**: Load sample recipes into the in-memory database.
- **Search Recipes**: Search recipes by name or cuisine.
- **Get Recipe by ID**: Retrieve a specific recipe by its ID.
- **Validation**: Input validation to ensure proper data handling.

## API Endpoints

### 1. **Save All Recipes**
- **Endpoint**: `GET /recipe/save`
- **Description**: Loads sample recipe data into the in-memory H2 database.
- **Response**:
   - `201 CREATED`: Recipes successfully loaded into the database.
   - `500 INTERNAL SERVER ERROR`: An error occurred while saving recipes.

### 2. **Get Recipe by ID**
- **Endpoint**: `GET /recipe/{id}`
- **Path Variable**:
   - `id` (Long): The ID of the recipe to retrieve.
- **Description**: Fetches a recipe by its ID.
- **Response**:
   - `200 OK`: Returns the recipe data in the response body.
   - `500 INTERNAL SERVER ERROR`: Recipe not found.

### 3. **Search Recipes by Keyword**
- **Endpoint**: `GET /recipe/search`
- **Query Parameter**:
   - `keyword` (String): A keyword to search for in recipe names or cuisines.
- **Description**: Searches recipes based on the provided keyword (in the name or cuisine).
- **Response**:
   - `200 OK`: Returns a list of matching recipes.
   - `204 NO CONTENT`: No recipes found matching the keyword.

## Technology Stack
- **Spring Boot**: Framework for building the application.
- **H2 Database**: In-memory database for storing recipe data.
- **Spring Web**: For RESTful API development.
- **Spring Validation**: For input data validation.
- **Swagger/OpenAPI**: For API documentation.
- **SLF4J & Logback**: For application logging.

## External Dependencies
- **https://dummyjson.com/recipes**: Third-party API used for loading sample recipes.

## Swagger Documentation
- Once the application is up and running, you can access the Swagger API documentation at: **http://localhost:8080/swagger-ui.html**

## Build & Run

### Prerequisites
- Java 17 or later
- Maven or Gradle (depending on your build tool)

### 1. **Clone the repository**
Clone the repository to your local machine:

```bash
git clone https://github.com/ranjansharma1/recipe-api.git
cd recipe-api
