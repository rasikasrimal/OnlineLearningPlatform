# Course Management API

## Overview

This API provides endpoints to manage courses in a learning platform. It supports CRUD operations: creating, reading, updating, and deleting courses.

## Base URL

/api/v1


## Endpoints

### 1. Get All Courses

- **URL:** `/getCourses`
- **Method:** `GET`
- **Description:** Retrieve a list of all courses.
- **Response:**

    ```json
    [
      {
        "id": 1,
        "courseName": "Course Name",
        "courseFee": "Course Fee",
        "courseDuration": "Course Duration",
        "courseInstructor": "Course Instructor"
      }
    ]
    ```

### 2. Add a Course

- **URL:** `/addCourse`
- **Method:** `POST`
- **Description:** Create a new course.
- **Request Body:**

    ```json
    {
      "courseName": "Course Name",
      "courseFee": "Course Fee",
      "courseDuration": "Course Duration",
      "courseInstructor": "Course Instructor"
    }
    ```
- **Response:**

    ```json
    "Course created successfully"
    ```

### 3. Get a Course by ID

- **URL:** `/getCourse/{id}`
- **Method:** `GET`
- **Description:** Retrieve a specific course by its ID.
- **Path Parameter:**
  - `id` (required): The ID of the course.
- **Response:**

    ```json
    {
      "id": 1,
      "courseName": "Course Name",
      "courseFee": "Course Fee",
      "courseDuration": "Course Duration",
      "courseInstructor": "Course Instructor"
    }
    ```

### 4. Update a Course

- **URL:** `/updateCourse/{id}`
- **Method:** `PUT`
- **Description:** Update the details of an existing course.
- **Path Parameter:**
  - `id` (required): The ID of the course to update.
- **Request Body:**

    ```json
    {
      "courseName": "Updated Course Name",
      "courseFee": "Updated Course Fee",
      "courseDuration": "Updated Course Duration",
      "courseInstructor": "Updated Course Instructor"
    }
    ```
- **Response:**

    ```json
    {
      "id": 1,
      "courseName": "Updated Course Name",
      "courseFee": "Updated Course Fee",
      "courseDuration": "Updated Course Duration",
      "courseInstructor": "Updated Course Instructor"
    }
    ```

### 5. Delete a Course

- **URL:** `/deleteCourse/{id}`
- **Method:** `DELETE`
- **Description:** Delete a specific course by its ID.
- **Path Parameter:**
  - `id` (required): The ID of the course to delete.
- **Response:**

    ```json
    {
      "DELETED => ": "Course with id 1 deleted successfully"
    }
    ```

## Error Handling

- **Resource Not Found (404)**
  - **Message:** `"Employee not found with id {id}"` or `"Employee not exist with id {id}"`

## Technologies Used

- **Spring Boot:** For creating RESTful APIs.
- **Jakarta Persistence:** For ORM.
- **Lombok:** For boilerplate code reduction.
- **Validation:** For input validation.

## How to Run

1. Clone the repository:
    ```sh
    git clone <repository-url>
    ```

2. Navigate to the project directory:
    ```sh
    cd <project-directory>
    ```

3. Build the project:
    ```sh
    ./mvnw clean install
    ```

4. Run the application:
    ```sh
    ./mvnw spring-boot:run
    ```

The API will be available at `http://localhost:8080/api/v1`.
