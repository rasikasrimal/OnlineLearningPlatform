package com.lms.repository;

import com.lms.model.Grade;
import org.springframework.data.mongodb.repository.MongoRepository;

/*
 * Created by Chathuri
 * */

public interface GradeRepository extends MongoRepository<Grade, String>, GradeRepositoryExtended {
}
