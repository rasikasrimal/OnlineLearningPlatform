package com.example.onlinelearningmanagementsystem.controller;

import com.example.onlinelearningmanagementsystem.model.ProgressTracking;
import com.example.onlinelearningmanagementsystem.service.ProgressTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/progress-tracking")
public class ProgressTrackingController {

    @Autowired
    private ProgressTrackingService progressTrackingService;

    @GetMapping
    public ResponseEntity<List<ProgressTracking>> getAllProgressTracking() {
        List<ProgressTracking> progressTrackingList = progressTrackingService.findAll();
        return new ResponseEntity<>(progressTrackingList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgressTracking> getProgressTrackingById(@PathVariable("id") int id) {
        ProgressTracking progressTracking = progressTrackingService.findById(id);
        return new ResponseEntity<>(progressTracking, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProgressTracking> createProgressTracking(@RequestBody ProgressTracking progressTracking) {
        ProgressTracking createdProgressTracking = progressTrackingService.save(progressTracking);
        return new ResponseEntity<>(createdProgressTracking, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgressTracking> updateProgressTracking(@PathVariable("id") int id, @RequestBody ProgressTracking progressTracking) {
        ProgressTracking updatedProgressTracking = progressTrackingService.update(id, progressTracking);
        return new ResponseEntity<>(updatedProgressTracking, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgressTracking(@PathVariable("id") int id) {
        progressTrackingService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
