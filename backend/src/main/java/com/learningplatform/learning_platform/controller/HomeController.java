package com.learningplatform.learning_platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index") // Ensure this matches your SecurityConfig
    public String home() {
        return "index"; // Ensure index.html is present in templates
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Ensure login.html is present in templates
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact"; // Ensure contact.html is present in templates
    }

}
