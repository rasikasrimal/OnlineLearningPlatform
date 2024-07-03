# Online Learning Platform Database Schema

## Users Table

| Column Name | Data Type | Constraints |
|-------------|------------|-------------|
| `user_id`   | INT        | Primary Key, Auto Increment |
| `username`  | VARCHAR(50)| Unique, Not Null |
| `password`  | VARCHAR(255)| Not Null |
| `email`     | VARCHAR(100)| Unique, Not Null |
| `first_name`| VARCHAR(50)| Not Null |
| `last_name` | VARCHAR(50)| Not Null |
| `role`      | ENUM('student', 'instructor', 'admin') | Not Null |
| `created_at`| TIMESTAMP  | Default CURRENT_TIMESTAMP |
| `updated_at`| TIMESTAMP  | Default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP |

```sql
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    role ENUM('student', 'instructor', 'admin') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```

## Courses Table
| Column Name  | Data Type  | Constraints |
|--------------|------------|-------------|
| `course_id`  | INT        | Primary Key, Auto Increment |
| `course_name`| VARCHAR(100)| Not Null |
| `description`| TEXT       | Not Null |
| `instructor_id`| INT      | Foreign Key to `Users.user_id` |
| `created_at` | TIMESTAMP  | Default CURRENT_TIMESTAMP |
| `updated_at` | TIMESTAMP  | Default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP |

```sql
CREATE TABLE courses (
    course_id INT AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    instructor_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (instructor_id) REFERENCES users(user_id)
);
```

## Modules Table
| Column Name  | Data Type  | Constraints |
|--------------|------------|-------------|
| `module_id`  | INT        | Primary Key, Auto Increment |
| `course_id`  | INT        | Foreign Key to `Courses.course_id` |
| `module_name`| VARCHAR(100)| Not Null |
| `order`      | INT        | Not Null |

```sql
CREATE TABLE modules (
    module_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT,
    module_name VARCHAR(100) NOT NULL,
    `order` INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

```

## Lessons Table
| Column Name  | Data Type  | Constraints |
|--------------|------------|-------------|
| `lesson_id`  | INT        | Primary Key, Auto Increment |
| `module_id`  | INT        | Foreign Key to `Modules.module_id` |
| `title`      | VARCHAR(100)| Not Null |
| `content`    | TEXT       | Not Null |
| `order`      | INT        | Not Null |

```sql
CREATE TABLE lessons (
    lesson_id INT AUTO_INCREMENT PRIMARY KEY,
    module_id INT,
    title VARCHAR(100) NOT NULL,
    content TEXT NOT NULL,
    `order` INT NOT NULL,
    FOREIGN KEY (module_id) REFERENCES modules(module_id)
);

```

## Enrollments Table
| Column Name  | Data Type  | Constraints |
|--------------|------------|-------------|
| `enrollment_id` | INT     | Primary Key, Auto Increment |
| `student_id`    | INT     | Foreign Key to `Users.user_id` |
| `course_id`     | INT     | Foreign Key to `Courses.course_id` |
| `enrollment_date`| TIMESTAMP | Default CURRENT_TIMESTAMP |
| `progress`      | DECIMAL(5, 2) | Default 0.00 |

```sql
CREATE TABLE enrollments (
    enrollment_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    course_id INT,
    enrollment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    progress DECIMAL(5, 2) DEFAULT 0.00,
    FOREIGN KEY (student_id) REFERENCES users(user_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

```

## Progress Tracking Table
| Column Name   | Data Type  | Constraints |
|---------------|------------|-------------|
| `progress_id` | INT        | Primary Key, Auto Increment |
| `student_id`  | INT        | Foreign Key to `Users.user_id` |
| `lesson_id`   | INT        | Foreign Key to `Lessons.lesson_id` |
| `completed`   | BOOLEAN    | Default False |
| `completion_date` | TIMESTAMP | Nullable |

```sql
CREATE TABLE progress_tracking (
    progress_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    lesson_id INT,
    completed BOOLEAN DEFAULT FALSE,
    completion_date TIMESTAMP NULL,
    FOREIGN KEY (student_id) REFERENCES users(user_id),
    FOREIGN KEY (lesson_id) REFERENCES lessons(lesson_id)
);

```

## Messages Table
| Column Name | Data Type  | Constraints |
|-------------|------------|-------------|
| `message_id`| INT        | Primary Key, Auto Increment |
| `sender_id` | INT        | Foreign Key to `Users.user_id` |
| `receiver_id`| INT       | Foreign Key to `Users.user_id` |
| `content`   | TEXT       | Not Null |
| `created_at`| TIMESTAMP  | Default CURRENT_TIMESTAMP |

```sql
CREATE TABLE messages (
    message_id INT AUTO_INCREMENT PRIMARY KEY,
    sender_id INT,
    receiver_id INT,
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (sender_id) REFERENCES users(user_id),
    FOREIGN KEY (receiver_id) REFERENCES users(user_id)
);

```

## Assignments Table
| Column Name  | Data Type  | Constraints |
|--------------|------------|-------------|
| `assignment_id` | INT     | Primary Key, Auto Increment |
| `module_id` | INT        | Foreign Key to `Modules.module_id` |
| `title`     | VARCHAR(100)| Not Null |
| `description`| TEXT      | Not Null |
| `due_date`  | DATE       | Not Null |

```sql
CREATE TABLE assignments (
    assignment_id INT AUTO_INCREMENT PRIMARY KEY,
    module_id INT,
    title VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    due_date DATE NOT NULL,
    FOREIGN KEY (module_id) REFERENCES modules(module_id)
);

```

## Assignment Submissions Table
| Column Name  | Data Type  | Constraints |
|--------------|------------|-------------|
| `assignment_submission_id` | INT | Primary Key, Auto Increment |
| `assignment_id` | INT      | Foreign Key to `Assignments.assignment_id` |
| `student_id`   | INT       | Foreign Key to `Users.user_id` |
| `submission_date` | TIMESTAMP | Default CURRENT_TIMESTAMP |
| `grade`       | DECIMAL(5, 2) | Nullable |

```sql
CREATE TABLE assignment_submissions (
    assignment_submission_id INT AUTO_INCREMENT PRIMARY KEY,
    assignment_id INT,
    student_id INT,
    submission_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    grade DECIMAL(5, 2) NULL,
    FOREIGN KEY (assignment_id) REFERENCES assignments(assignment_id),
    FOREIGN KEY (student_id) REFERENCES users(user_id)
);

```

## Grades Table
| Column Name  | Data Type  | Constraints |
|--------------|------------|-------------|
| `grade_id`   | INT        | Primary Key, Auto Increment |
| `grade`      | VARCHAR(2) | Not Null |
| `value`      | DECIMAL(5, 2) | Not Null |

```sql
CREATE TABLE grades (
    grade_id INT AUTO_INCREMENT PRIMARY KEY,
    grade VARCHAR(2) NOT NULL,
    value DECIMAL(5, 2) NOT NULL
);

```

## Marks Table
| Column Name  | Data Type  | Constraints |
|--------------|------------|-------------|
| `mark_id`    | INT        | Primary Key, Auto Increment |
| `student_id` | INT        | Foreign Key to `Users.user_id` |
| `course_id`  | INT        | Foreign Key to `Courses.course_id` |
| `module_id`  | INT        | Foreign Key to `Modules.module_id` |
| `grade_id`   | INT        | Foreign Key to `Grades.grade_id` |
| `created_at` | TIMESTAMP  | Default CURRENT_TIMESTAMP |
| `updated_at` | TIMESTAMP  | Default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP |

```sql
CREATE TABLE marks (
    mark_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    course_id INT,
    module_id INT,
    grade_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES users(user_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id),
    FOREIGN KEY (module_id) REFERENCES modules(module_id),
    FOREIGN KEY (grade_id) REFERENCES grades(grade_id)
);
```

