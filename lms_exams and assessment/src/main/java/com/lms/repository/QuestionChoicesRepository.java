package com.lms.repository;

/*
 * Created by Chathuri
 * */

import com.lms.model.QuestionChoices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//@Repository

public interface QuestionChoicesRepository extends MongoRepository<QuestionChoices, String>, QuestionChoicesRepositoryExtended {
}
