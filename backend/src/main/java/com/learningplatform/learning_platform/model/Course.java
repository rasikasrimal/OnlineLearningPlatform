package com.learningplatform.learning_platform.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

//Course details table
@Table(name = "course_details")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @NotEmpty(message = "Course name is mandatory")
    @Column(name = "course_name")
    private String courseName;

    @NotEmpty(message = "Course Fee is mandatory")
    @Column(name = "course_fee")
    private String courseFee;

    @NotEmpty(message = "Course Duration is mandatory")
    @Column(name = "course_duration")
    private String courseDuration;

    @NotEmpty(message = "Course Instructor is mandatory")
    @Column(name = "course_instructor")
    private String courseInstructor;


    public @NotEmpty(message = "Course name is mandatory") String getCourseName() {
        return courseName;
    }

    public void setCourseName(@NotEmpty(message = "Course name is mandatory") String courseName) {
        this.courseName = courseName;
    }

    public @NotEmpty(message = "Course Fee is mandatory") String getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(@NotEmpty(message = "Course Fee is mandatory") String courseFee) {
        this.courseFee = courseFee;
    }

    public @NotEmpty(message = "Course Duration is mandatory") String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(@NotEmpty(message = "Course Duration is mandatory") String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public @NotEmpty(message = "Course Instructor is mandatory") String getCourseInstructor() {
        return courseInstructor;
    }

    public void setCourseInstructor(@NotEmpty(message = "Course Instructor is mandatory") String courseInstructor) {
        this.courseInstructor = courseInstructor;
    }
}
