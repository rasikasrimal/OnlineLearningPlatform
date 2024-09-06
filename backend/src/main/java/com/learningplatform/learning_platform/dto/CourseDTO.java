package com.learningplatform.learning_platform.dto;

import jakarta.validation.constraints.NotEmpty;

public class CourseDTO {

    @NotEmpty(message = "courseName required")
    private String courseName;

    @NotEmpty(message = "courseFee required")
    private String courseFee;

    @NotEmpty(message = "courseDuration required")
    private String courseDuration;

    @NotEmpty(message = "courseInstructor required")
    private String courseInstructor;

    public @NotEmpty(message = "courseName required") String getCourseName() {
        return courseName;
    }

    public void setCourseName(@NotEmpty(message = "courseName required") String courseName) {
        this.courseName = courseName;
    }

    public @NotEmpty(message = "courseFee required") String getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(@NotEmpty(message = "courseFee required") String courseFee) {
        this.courseFee = courseFee;
    }

    public @NotEmpty(message = "courseDuration required") String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(@NotEmpty(message = "courseDuration required") String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public @NotEmpty(message = "courseInstructor required") String getCourseInstructor() {
        return courseInstructor;
    }

    public void setCourseInstructor(@NotEmpty(message = "courseInstructor required") String courseInstructor) {
        this.courseInstructor = courseInstructor;
    }
}
