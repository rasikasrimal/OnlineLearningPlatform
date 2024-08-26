package com.example.onlinelearningmanagementsystem.service;

import com.example.onlinelearningmanagementsystem.model.AssignmentSubmission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.onlinelearningmanagementsystem.repository.AssignmentSubmissionRepository;
import java.util.List;
import java.util.Optional;

@Service // Marks this class as a Spring service, indicating that it contains business logic.
public class AssignmentSubmissionService {

    @Autowired // Automatically injects an instance of AssignmentSubmissionRepository into this service.
    private AssignmentSubmissionRepository assignmentSubmissionRepository;

    // Create a new AssignmentSubmission
    public AssignmentSubmission createAssignmentSubmission(AssignmentSubmission assignmentSubmission) {
        return assignmentSubmissionRepository.save(assignmentSubmission); // Saves the AssignmentSubmission entity to the database.
    }

    // Get all AssignmentSubmissions
    public List<AssignmentSubmission> getAllAssignmentSubmissions() {
        return assignmentSubmissionRepository.findAll(); // Retrieves all AssignmentSubmissions from the database.
    }

    // Get a specific AssignmentSubmission by ID
    public AssignmentSubmission getAssignmentSubmissionById(int id) {
        Optional<AssignmentSubmission> optionalAssignmentSubmission = assignmentSubmissionRepository.findById(id);
        return optionalAssignmentSubmission.orElseThrow(() -> new RuntimeException("AssignmentSubmission not found with id: " + id)); // Retrieves the AssignmentSubmission by ID or throws an exception if not found.
    }

    // Update an existing AssignmentSubmission
    public AssignmentSubmission updateAssignmentSubmission(int id, AssignmentSubmission assignmentSubmissionDetails) {
        AssignmentSubmission existingAssignmentSubmission = getAssignmentSubmissionById(id); // Retrieves the existing AssignmentSubmission by ID.

        // Update the existing AssignmentSubmission with new details.
        existingAssignmentSubmission.setAssignmentID(assignmentSubmissionDetails.getAssignmentID());
        existingAssignmentSubmission.setStudentID(assignmentSubmissionDetails.getStudentID());
        existingAssignmentSubmission.setSubmissionDate(assignmentSubmissionDetails.getSubmissionDate());
        existingAssignmentSubmission.setGrade(assignmentSubmissionDetails.getGrade());

        return assignmentSubmissionRepository.save(existingAssignmentSubmission); // Saves the updated AssignmentSubmission to the database.
    }

    // Delete an AssignmentSubmission
    public void deleteAssignmentSubmission(int id) {
        AssignmentSubmission existingAssignmentSubmission = getAssignmentSubmissionById(id); // Retrieves the existing AssignmentSubmission by ID.
        assignmentSubmissionRepository.delete(existingAssignmentSubmission); // Deletes the AssignmentSubmission from the database.
    }
}
