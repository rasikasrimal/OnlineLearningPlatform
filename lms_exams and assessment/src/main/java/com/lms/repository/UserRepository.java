package com.lms.repository;

import com.lms.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/*
 * Created by Chathuri
 * */
//@Qualifier("users")
//@Repository

public interface UserRepository extends MongoRepository<User, String> , UserRepositoryExtended {

    @Query(value = "{email: ?0}")
    User findByEmail(String email);

}
