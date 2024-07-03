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

## Courses Table
| Column Name  | Data Type  | Constraints |
|--------------|------------|-------------|
| `course_id`  | INT        | Primary Key, Auto Increment |
| `course_name`| VARCHAR(100)| Not Null |
| `description`| TEXT       | Not Null |
| `instructor_id`| INT      | Foreign Key to `Users.user_id` |
| `created_at` | TIMESTAMP  | Default CURRENT_TIMESTAMP |
| `updated_at` | TIMESTAMP  | Default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP |

## Modules Table
| Column Name  | Data Type  | Constraints |
|--------------|------------|-------------|
| `module_id`  | INT        | Primary Key, Auto Increment |
| `course_id`  | INT        | Foreign Key to `Courses.course_id` |
| `module_name`| VARCHAR(100)| Not Null |
| `order`      | INT        | Not Null |

## Lessons Table
| Column Name  | Data Type  | Constraints |
|--------------|------------|-------------|
| `lesson_id`  | INT        | Primary Key, Auto Increment |
| `module_id`  | INT        | Foreign Key to `Modules.module_id` |
| `title`      | VARCHAR(100)| Not Null |
| `content`    | TEXT       | Not Null |
| `order`      | INT        | Not Null |

## Enrollments Table
| Column Name  | Data Type  | Constraints |
|--------------|------------|-------------|
| `enrollment_id` | INT     | Primary Key, Auto Increment |
| `student_id`    | INT     | Foreign Key to `Users.user_id` |
| `course_id`     | INT     | Foreign Key to `Courses.course_id` |
| `enrollment_date`| TIMESTAMP | Default CURRENT_TIMESTAMP |
| `progress`      | DECIMAL(5, 2) | Default 0.00 |

## Progress Tracking Table
| Column Name   | Data Type  | Constraints |
|---------------|------------|-------------|
| `progress_id` | INT        | Primary Key, Auto Increment |
| `student_id`  | INT        | Foreign Key to `Users.user_id` |
| `lesson_id`   | INT        | Foreign Key to `Lessons.lesson_id` |
| `completed`   | BOOLEAN    | Default False |
| `completion_date` | TIMESTAMP | Nullable |

## Messages Table
| Column Name | Data Type  | Constraints |
|-------------|------------|-------------|
| `message_id`| INT        | Primary Key, Auto Increment |
| `sender_id` | INT        | Foreign Key to `Users.user_id` |
| `receiver_id`| INT       | Foreign Key to `Users.user_id` |
| `content`   | TEXT       | Not Null |
| `created_at`| TIMESTAMP  | Default CURRENT_TIMESTAMP |

## Assignments Table
| Column Name  | Data Type  | Constraints |
|--------------|------------|-------------|
| `assignment_id` | INT     | Primary Key, Auto Increment |
| `module_id` | INT        | Foreign Key to `Modules.module_id` |
| `title`     | VARCHAR(100)| Not Null |
| `description`| TEXT      | Not Null |
| `due_date`  | DATE       | Not Null |

## Assignment Submissions Table
| Column Name  | Data Type  | Constraints |
|--------------|------------|-------------|
| `assignment_submission_id` | INT | Primary Key, Auto Increment |
| `assignment_id` | INT      | Foreign Key to `Assignments.assignment_id` |
| `student_id`   | INT       | Foreign Key to `Users.user_id` |
| `submission_date` | TIMESTAMP | Default CURRENT_TIMESTAMP |
| `grade`       | DECIMAL(5, 2) | Nullable |

## Grades Table
| Column Name  | Data Type  | Constraints |
|--------------|------------|-------------|
| `grade_id`   | INT        | Primary Key, Auto Increment |
| `grade`      | VARCHAR(2) | Not Null |
| `value`      | DECIMAL(5, 2) | Not Null |

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
