package com.learningplatform.learning_platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/userManagement")
    public String userManagementPage() {
        return "userManagement"; // This refers to userManagement.html in the templates directory
    }
}
