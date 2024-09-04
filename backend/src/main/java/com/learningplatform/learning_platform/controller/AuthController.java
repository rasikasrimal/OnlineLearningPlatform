package com.learningplatform.learning_platform.controller;

import com.learningplatform.learning_platform.model.User;
import com.learningplatform.learning_platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    // Display the signup form
    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";  // Corresponds to signup.html in resources/templates
    }

  

    // Display the login form
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";  // Corresponds to login.html in resources/templates
    }

    // Handle login submission (this is usually managed by Spring Security)
    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user) {
        // Add login logic here (Spring Security typically handles this)
        return "home";  // Redirect to a home page after successful login
    }
}
