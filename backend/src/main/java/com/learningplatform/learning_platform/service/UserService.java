package com.learningplatform.learning_platform.service;

import com.learningplatform.learning_platform.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Service interface for User management.
 */
public interface UserService {
    List<User> getAllUsers();
    User createUser(User user);
    ResponseEntity<User> getUserById(Integer id);
    ResponseEntity<User> updateUser(Integer id, User user);
    ResponseEntity<Void> deleteUser(Integer id);
}
