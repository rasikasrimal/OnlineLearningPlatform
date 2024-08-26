package com.example.onlinelearningmanagementsystem.repository;

import com.example.onlinelearningmanagementsystem.model.AssignmentSubmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentSubmissionRepository extends JpaRepository<AssignmentSubmission, Integer> {
    // Custom query methods can be added here if needed

}
