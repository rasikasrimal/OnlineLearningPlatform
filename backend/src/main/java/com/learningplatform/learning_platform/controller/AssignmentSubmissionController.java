package com.learningplatform.learning_platform.controller;

import com.example.onlinelearningmanagementsystem.model.AssignmentSubmission;
import com.example.onlinelearningmanagementsystem.service.AssignmentSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController // Indicates that this class is a REST controller that handles HTTP requests.
@RequestMapping("/api/assignmentsubmissions") // Maps HTTP requests to "/api/assignmentsubmissions" to this controller.
public class AssignmentSubmissionController {

    @Autowired // Automatically injects an instance of AssignmentSubmissionService into this controller.
    private AssignmentSubmissionService assignmentSubmissionService;

    // Create a new AssignmentSubmission
    @PostMapping("/create") // Handles POST requests to create a new AssignmentSubmission.
    public AssignmentSubmission createAssignmentSubmission(@RequestBody AssignmentSubmission assignmentSubmission) {
        return assignmentSubmissionService.createAssignmentSubmission(assignmentSubmission);
    }

    // Get all AssignmentSubmissions
    @GetMapping ("/view")// Handles GET requests to retrieve all AssignmentSubmissions.
    public List<AssignmentSubmission> getAllAssignmentSubmissions() {
        return assignmentSubmissionService.getAllAssignmentSubmissions();
        // Returns the list of AssignmentSubmissions with HTTP status 200 (OK).
    }

    // Get a specific AssignmentSubmission by ID
    @GetMapping("/{id}") // Handles GET requests to retrieve a specific AssignmentSubmission by its ID.
    public ResponseEntity<AssignmentSubmission> getAssignmentSubmissionById(@PathVariable("id") int id) {
        AssignmentSubmission assignmentSubmission = assignmentSubmissionService.getAssignmentSubmissionById(id);
        return new ResponseEntity<>(assignmentSubmission, HttpStatus.OK); // Returns the requested AssignmentSubmission with HTTP status 200 (OK).
    }

    // Update an existing AssignmentSubmission
    @PutMapping("/{id}") // Handles PUT requests to update an existing AssignmentSubmission.
    public ResponseEntity<AssignmentSubmission> updateAssignmentSubmission(@PathVariable("id") int id, @RequestBody AssignmentSubmission assignmentSubmission) {
        AssignmentSubmission updatedAssignmentSubmission = assignmentSubmissionService.updateAssignmentSubmission(id, assignmentSubmission);
        return new ResponseEntity<>(updatedAssignmentSubmission, HttpStatus.OK); // Returns the updated AssignmentSubmission with HTTP status 200 (OK).
    }

    // Delete an AssignmentSubmission
    @DeleteMapping("/{id}") // Handles DELETE requests to delete an AssignmentSubmission by its ID.
    public String deleteAssignmentSubmission(@PathVariable("id") int id) {
        assignmentSubmissionService.deleteAssignmentSubmission(id);
        return "Deleted successfully"; // Returns HTTP status 204 (No Content) after successful deletion.
    }
}
