package com.learningplatform.learning_platform.repository;

import com.learningplatform.learning_platform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for User entity.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
