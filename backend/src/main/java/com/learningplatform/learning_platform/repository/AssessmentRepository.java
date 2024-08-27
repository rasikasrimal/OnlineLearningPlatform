package com.learningplatform.learning_platform.repository;

import com.lms.assessment.lms_assessment.model.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
}
