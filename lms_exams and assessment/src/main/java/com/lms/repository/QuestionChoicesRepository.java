package com.lms.repository;

/*
 * Created by Chathuri
 * */

import com.lms.model.QuestionChoices;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionChoicesRepository extends MongoRepository<QuestionChoices, String>, QuestionChoicesRepositoryExtended {
}
