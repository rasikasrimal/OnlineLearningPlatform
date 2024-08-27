package com.learningplatform.learning_platform.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity

public class AssignmentSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int assignmentSubmissionID;


    private int assignmentID;


    private int studentID;


    private Date submissionDate;


    private int grade;

    // Getters and Setters for each field

    public int getAssignmentSubmissionID() {
        return assignmentSubmissionID;
    }

    public void setAssignmentSubmissionID(int assignmentSubmissionID) {
        this.assignmentSubmissionID = assignmentSubmissionID;
    }

    public int getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(int assignmentID) {
        this.assignmentID = assignmentID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
