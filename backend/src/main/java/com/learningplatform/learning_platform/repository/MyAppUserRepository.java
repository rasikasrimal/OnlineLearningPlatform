package com.learningplatform.learning_platform.repository;

import com.learningplatform.learning_platform.model.MyAppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MyAppUserRepository extends JpaRepository<MyAppUser, Long> {

    Optional<MyAppUser> findByUsername(String username);

}
