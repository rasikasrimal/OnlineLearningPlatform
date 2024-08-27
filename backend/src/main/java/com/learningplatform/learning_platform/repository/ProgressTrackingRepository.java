package com.example.onlinelearningmanagementsystem.repository;

import com.example.onlinelearningmanagementsystem.model.ProgressTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressTrackingRepository extends JpaRepository<ProgressTracking, Integer> {
    // Custom query methods can be added here if needed
}
