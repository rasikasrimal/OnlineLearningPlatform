package com.learningplatform.learning_platform.service;

import com.learningplatform.learning_platform.model.AppUser;
import com.learningplatform.learning_platform.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        // Fetch the AppUser using the provided email
        AppUser appUser = appUserRepository.findByEmail(email);

        // If appUser is null, throw an exception
        if (appUser == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        // Return the UserDetails object directly
        return User
                .withUsername(appUser.getEmail())   // Set the email as the username
                .password(appUser.getPassword())    // Set the password from the AppUser object
                .roles(appUser.getRole())           // Set roles (ensure this method returns a suitable format)
                .build();
    }
}
