package com.lms.repository;

import com.lms.model.Grade;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/*
 * Created by Chathuri
 * */

//@Repository
public interface GradeRepository extends MongoRepository<Grade, String>, GradeRepositoryExtended {
}
