package com.learningplatform.learning_platform.controller;
import com.learningplatform.learning_platform.dto.CourseDTO;
import com.learningplatform.learning_platform.exception.ResourceNotFoundException;
import com.learningplatform.learning_platform.model.Course;
import com.learningplatform.learning_platform.repository.CourseRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//REST API controller
@Controller
@RequestMapping("/api/v1")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;


    @GetMapping("/getCourses")
    public String getCourses(Model model) {
        var courses = courseRepository.findAll(Sort.by(Sort.Direction.DESC, "courseName")); // Sorting by courseName field
        model.addAttribute("courses", courses);
        return "courses/CourseHome";  // Return the view name
    }

    @GetMapping("/addCourse")
    public String addCourse(Model model) {
        model.addAttribute("courseDTO", new CourseDTO());
        return "courses/CourseAdd";
    }


    @PostMapping("/addCourse")
    public String addCourse(@Valid @ModelAttribute() CourseDTO courseDTO, BindingResult bindingResult) {

        if (courseRepository.findByCourseName(courseDTO.getCourseName()) != null) {
            bindingResult.addError(
                    new FieldError("courseDTO", "courseName", courseDTO.getCourseName(), false, null, null, "Email already used")
            );
        }

        if (bindingResult.hasErrors()) {
            return "courses/CourseAdd";
        }

        Course course = new Course();
        course.setCourseName(courseDTO.getCourseName());
        course.setCourseFee(courseDTO.getCourseFee());
        course.setCourseDuration(courseDTO.getCourseDuration());
        course.setCourseInstructor(courseDTO.getCourseInstructor());

        courseRepository.save(course);

        return "redirect:/api/v1/getCourses";

    }

    //build REST API for get courses by id
    @GetMapping("/getCourse/{id}")
    public Course getCourse(@PathVariable long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
        return ResponseEntity.ok(course).getBody();
    }


    @GetMapping("/updateCourse")
    public String updateCourse(Model model, @RequestParam Long id) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course == null) {
            return "redirect:/api/v1/getCourses";
        }

        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseName(course.getCourseName());
        courseDTO.setCourseFee(course.getCourseFee());
        courseDTO.setCourseDuration(course.getCourseDuration());
        courseDTO.setCourseInstructor(course.getCourseInstructor());

        model.addAttribute("courseDTO", courseDTO);
        model.addAttribute("courseId", id);  // Add courseId to the model

        return "courses/CourseUpdate";
    }


    @PostMapping("/updateCourse")
    public String updateCourse(
            @RequestParam Long id,
            @Valid @ModelAttribute("courseDTO") CourseDTO courseDTO,
            BindingResult bindingResult,
            Model model
    ) {
        // Retrieve the existing course
        Course course = courseRepository.findById(id).orElse(null);
        if (course == null) {
            return "redirect:/api/v1/getCourses";
        }

        // Check for validation errors
        if (bindingResult.hasErrors()) {
            model.addAttribute("courseDTO", courseDTO); // Add courseDTO to model in case of errors
            return "courses/CourseUpdate";
        }

        // Update course details
        course.setCourseName(courseDTO.getCourseName());
        course.setCourseFee(courseDTO.getCourseFee());
        course.setCourseDuration(courseDTO.getCourseDuration());
        course.setCourseInstructor(courseDTO.getCourseInstructor());

        try {
            courseRepository.save(course);
        } catch (Exception ex) {
            bindingResult.addError(
                    new FieldError("courseDTO", "courseName", courseDTO.getCourseName(), false, null, null, "Course Name already used")
            );
            model.addAttribute("courseDTO", courseDTO); // Add courseDTO to model in case of errors
            return "courses/CourseUpdate";
        }

        // Redirect to the list of courses
        return "redirect:/api/v1/getCourses";
    }


    @GetMapping("/deleteCourse")
    public String deleteCourse(@RequestParam Long id) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            courseRepository.delete(course);
        }
        return "redirect:/api/v1/getCourses";
    }





//    //build REST API for delete courses
//    @DeleteMapping("/deleteCourse/{id}")
//    public ResponseEntity<Map<String, String>> deleteCourse(@PathVariable long id) {
//        Course course = courseRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id " + id));
//        courseRepository.delete(course);
//
//        Map<String, String> response = new HashMap<>();
//        response.put("DELETED => ","Course with id " + id + " deleted successfully");
//        return ResponseEntity.status(HttpStatus.OK).body(response);
//
//    }
//
//
//
//
 }
