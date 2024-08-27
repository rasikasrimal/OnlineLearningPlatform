package com.lms.repository;

import com.lms.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

/*
 * Created by Chathuri
 * */

public interface QuestionRepository extends MongoRepository<Question, String>, QuestionRepositoryExtended{
}
