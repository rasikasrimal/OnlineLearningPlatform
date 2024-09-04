package com.lms.service;

import com.lms.model.Role;
import com.lms.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Created by Chathuri
 * */

//@Service
public interface UserService extends UserDetailsService {

    User save(User user);

    List<User> getAll();

    void delete(User user);

    List<User> getUserByRole(Role role);

    User findById(String id);
}
