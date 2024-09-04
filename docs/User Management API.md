# User Management API

## Author Information
- **Author**: Rasika Srimal

## Overview

This API provides CRUD operations for managing users. It includes endpoints for viewing, creating, updating, and deleting users. The API is built with Spring Boot and can be tested using tools like Postman or directly through an HTML frontend.

## Base URL
http://localhost:8080/api/v1

## Endpoints

### 1. **Get All Users**

- **URL**: `/users`
- **Method**: `GET`
- **Description**: Retrieve a list of all users.

#### Response

- **Status Code**: `200 OK`
- **Body**: 
    ```json
    [
        {
            "id": 1,
            "username": "user1",
            "email": "user1@example.com"
        },
    ]
    ```

### 2. **Get User by ID**

- **URL**: `/users/{id}`
- **Method**: `GET`
- **Description**: Retrieve a specific user by their ID.

#### URL Parameters

- **ID**: The ID of the user to retrieve.

#### Response

- **Status Code**: `200 OK`
- **Body**: 
    ```json
    {
        "id": 1,
        "username": "user1",
        "email": "user1@example.com"
    }
    ```

### 3. **Create User**

- **URL**: `/users`
- **Method**: `POST`
- **Description**: Create a new user.

#### Request Body

- **Content-Type**: `application/json`
- **Body**:
    ```json
    {
        "username": "newuser",
        "email": "newuser@example.com",
        "password": "password123"
    }
    ```

#### Response

- **Status Code**: `201 Created`
- **Body**: 
    ```json
    {
        "id": 2,
        "username": "newuser",
        "email": "newuser@example.com"
    }
    ```

### 4. **Update User**

- **URL**: `/users/{id}`
- **Method**: `PUT`
- **Description**: Update an existing user by their ID.

#### URL Parameters

- **ID**: The ID of the user to update.

#### Request Body

- **Content-Type**: `application/json`
- **Body**:
    ```json
    {
        "username": "updateduser",
        "email": "updateduser@example.com",
        "password": "newpassword456"
    }
    ```

#### Response

- **Status Code**: `200 OK`
- **Body**: 
    ```json
    {
        "id": 1,
        "username": "updateduser",
        "email": "updateduser@example.com"
    }
    ```

### 5. **Delete User**

- **URL**: `/users/{id}`
- **Method**: `DELETE`
- **Description**: Delete a user by their ID.

#### URL Parameters

- **ID**: The ID of the user to delete.

#### Response

- **Status Code**: `200 OK`
- **Body**:
    ```json
    {
        "Status": "User with id {id} deleted successfully"
    }
    ```

## Error Handling

- **404 Not Found**: When the requested resource does not exist (e.g., a user with a given ID).
- **400 Bad Request**: When the request body is invalid or missing required fields.

## Testing the API

You can test the API using [Postman](https://www.postman.com/) with the following endpoints:

- **Get All Users**: `GET http://localhost:8080/api/v1/users`
- **Get User by ID**: `GET http://localhost:8080/api/v1/users/{id}`
- **Create User**: `POST http://localhost:8080/api/v1/users`
- **Update User**: `PUT http://localhost:8080/api/v1/users/{id}`
- **Delete User**: `DELETE http://localhost:8080/api/v1/users/{id}`

## Frontend Integration

An HTML interface is available to interact with the API. You can test the endpoints directly from the frontend to ensure seamless functionality.
