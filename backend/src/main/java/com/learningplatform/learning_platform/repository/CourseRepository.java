package com.learningplatform.learning_platform.repository;
import com.learningplatform.learning_platform.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    public Course findByCourseName(String name);
}