package com.lms.repository;

/*
 * Created by Chathuri
 * */

import com.lms.model.StudentsExams;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface StudentsExamsRepository extends MongoRepository<StudentsExams, String>, StudentsExamsRepositoryExtended{
}
