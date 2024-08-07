package com.learningplatform.learning_platform.model;
import jakarta.persistence.*;
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

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_fee")
    private String courseFee;

    @Column(name = "course_duration")
    private String courseDuration;

    @Column(name = "course_instructor")
    private String courseInstructor;
}
