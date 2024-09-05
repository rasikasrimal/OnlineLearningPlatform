package com.lms.repository;

/*
 * Created by Chathuri
 * */

import com.lms.model.StudentsExams;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface StudentsExamsRepository extends MongoRepository<StudentsExams, String>, StudentsExamsRepositoryExtended{
}
