package com.lms.repository;

import com.lms.model.Role;
import com.lms.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;


//@Repository
public interface UserRepositoryExtended {

    User userById(String id);

    List<User> getUserByRole(Role role);
}
