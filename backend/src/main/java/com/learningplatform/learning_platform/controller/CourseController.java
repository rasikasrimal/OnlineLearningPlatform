package com.learningplatform.learning_platform.controller;
import com.learningplatform.learning_platform.exception.ResourceNotFoundException;
import com.learningplatform.learning_platform.model.Course;
import com.learningplatform.learning_platform.repository.CourseRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//REST API controller
@RestController
@RequestMapping("/api/v1")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;


    //build REST API for view courses
    @GetMapping("/getCourses")
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }


    //build REST API for add courses
    @PostMapping("/addCourse")
    public ResponseEntity<String> createCourse(@Valid @RequestBody Course course) {
         courseRepository.save(course);
        return ResponseEntity.status(HttpStatus.CREATED).body("Course created successfully");
    }

    //build REST API for get courses by id
    @GetMapping("/getCourse/{id}")
    public Course getCourse(@PathVariable long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
        return ResponseEntity.ok(course).getBody();
    }


    //build REST API for edit courses
    @PutMapping("/updateCourse/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id,@RequestBody Course courseDetails) {
        Course updateCourse = (Course) (Course) courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id " + id));

        updateCourse.setCourseName(courseDetails.getCourseName());
        updateCourse.setCourseFee(courseDetails.getCourseFee());
        updateCourse.setCourseDuration(courseDetails.getCourseDuration());
        updateCourse.setCourseInstructor(courseDetails.getCourseInstructor());

        courseRepository.save(updateCourse);
        return ResponseEntity.ok(updateCourse);
    }


    //build REST API for delete courses
    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity<Map<String, String>> deleteCourse(@PathVariable long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id " + id));
        courseRepository.delete(course);

        Map<String, String> response = new HashMap<>();
        response.put("DELETED => ","Course with id " + id + " deleted successfully");
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
}
