package com.learningplatform.learning_platform.service;

import com.learningplatform.learning_platform.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Service interface for User management
 * Authors:
 * - Rasika
 * Date: 8/9/2024
 */
public interface UserService {
    List<User> getAllUsers();
    User createUser(User user);
    ResponseEntity<User> getUserById(Long id);
    ResponseEntity<User> updateUser(Long id, User user);
    ResponseEntity<Void> deleteUser(Long id);
}
