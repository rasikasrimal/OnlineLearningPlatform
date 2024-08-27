package com.lms.repository;

import com.lms.model.Exam;
import org.springframework.data.mongodb.repository.MongoRepository;

/*
 * Created by Chathuri
 * */


public interface ExamRepository extends MongoRepository<Exam, String> , ExamRepositoryExtended {
}
