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
}
