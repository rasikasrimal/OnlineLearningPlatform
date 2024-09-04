package com.lms.repository;

import com.lms.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/*
 * Created by Chathuri
 * */

//@Repository
public interface QuestionRepository extends MongoRepository<Question, String>, QuestionRepositoryExtended{
}
