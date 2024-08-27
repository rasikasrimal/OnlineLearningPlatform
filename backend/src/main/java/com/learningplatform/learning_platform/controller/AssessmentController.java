package com.learningplatform.learning_platform.controller;

import com.lms.assessment.lms_assessment.Service.AssessmentService;
import com.lms.assessment.lms_assessment.model.Assessment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/assessments")
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;

    @GetMapping

    public String getAllAssessments(Model model) {
        List<Assessment> assessments = assessmentService.getAllAssessments();
        model.addAttribute("assessments", assessments);
        return "assessments/list";
    }

    @GetMapping("/new")
    public String createAssessmentForm(Model model) {
        model.addAttribute("assessment", new Assessment());
        return "assessments/form";
    }

    @PostMapping
    public String saveAssessment(@ModelAttribute Assessment assessment) {
        assessmentService.createOrUpdateAssessment(assessment);
        return "redirect:/assessments";
    }

    @GetMapping("/edit/{id}")
    public String editAssessmentForm(@PathVariable Long id, Model model) {
        Assessment assessment = assessmentService.getAssessmentById(id);
        model.addAttribute("assessment", assessment);
        return "assessments/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteAssessment(@PathVariable Long id) {
        assessmentService.deleteAssessment(id);
        return "redirect:/assessments";
    }

}
