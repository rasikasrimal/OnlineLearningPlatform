CREATE DATABASE IF NOT EXISTS learning_platform;

USE learning_platform;

CREATE DATABASE IF NOT EXISTS learning_platform;

USE learning_platform;

CREATE TABLE IF NOT EXISTS students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    CONSTRAINT unique_username_student UNIQUE (username)
);

CREATE TABLE IF NOT EXISTS instructors (
    instructor_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    CONSTRAINT unique_username_instructor UNIQUE (username)
);


CREATE TABLE IF NOT EXISTS admins (
    admin_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    CONSTRAINT unique_username_admin UNIQUE (username)
);









CREATE TABLE courses (
    course_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    instructor_id INT,
    FOREIGN KEY (instructor_id) REFERENCES users(user_id)
);

CREATE TABLE enrollments (
    enrollment_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    course_id INT,
    enrollment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    completion_status ENUM('incomplete', 'complete'),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

CREATE TABLE modules (
    module_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    sequence_order INT,
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

CREATE TABLE lessons (
    lesson_id INT AUTO_INCREMENT PRIMARY KEY,
    module_id INT,
    title VARCHAR(100) NOT NULL,
    content TEXT,
    sequence_order INT,
    FOREIGN KEY (module_id) REFERENCES modules(module_id)
);

CREATE TABLE assignments (
    assignment_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    deadline DATETIME,
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

CREATE TABLE grades (
    grade_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    assignment_id INT,
    grade DECIMAL(5,2),
    feedback TEXT,
    graded_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (assignment_id) REFERENCES assignments(assignment_id)
);

CREATE TABLE messages (
    message_id INT AUTO_INCREMENT PRIMARY KEY,
    sender_id INT,
    receiver_id INT,
    subject VARCHAR(255) NOT NULL,
    content TEXT,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (sender_id) REFERENCES users(user_id),
    FOREIGN KEY (receiver_id) REFERENCES users(user_id)
);
