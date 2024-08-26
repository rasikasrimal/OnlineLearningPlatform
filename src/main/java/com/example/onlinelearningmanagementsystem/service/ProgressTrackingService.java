package com.example.onlinelearningmanagementsystem.service;


import com.example.onlinelearningmanagementsystem.model.ProgressTracking;
import com.example.onlinelearningmanagementsystem.repository.ProgressTrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgressTrackingService {



    @Autowired
    private ProgressTrackingRepository progressTrackingRepository;

    // Find all progress tracking records
    public List<ProgressTracking> findAll() {
        return progressTrackingRepository.findAll();
    }

    // Find a progress tracking record by ID
    public ProgressTracking findById(int id) {
        Optional<ProgressTracking> optionalProgressTracking = progressTrackingRepository.findById(id);
        if (optionalProgressTracking.isPresent()) {
            return optionalProgressTracking.get();
        } else {
            throw new RuntimeException("ProgressTracking not found for id: " + id);
        }
    }

    // Save a new progress tracking record
    public ProgressTracking save(ProgressTracking progressTracking) {
        return progressTrackingRepository.save(progressTracking);
    }

    // Update an existing progress tracking record
    public ProgressTracking update(int id, ProgressTracking progressTracking) {
        if (progressTrackingRepository.existsById(id)) {
            progressTracking.setProgressId(id);
            return progressTrackingRepository.save(progressTracking);
        } else {
            throw new RuntimeException("ProgressTracking not found for id: " + id);
        }
    }

    // Delete a progress tracking record by ID
    public void delete(int id) {
        if (progressTrackingRepository.existsById(id)) {
            progressTrackingRepository.deleteById(id);
        } else {
            throw new RuntimeException("ProgressTracking not found for id: " + id);
        }
    }
}

