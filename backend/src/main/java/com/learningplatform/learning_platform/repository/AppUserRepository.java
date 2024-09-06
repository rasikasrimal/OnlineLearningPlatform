package com.learningplatform.learning_platform.repository;

import com.learningplatform.learning_platform.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    public AppUser findByEmail(String email);
}
