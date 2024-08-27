package com.lms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/*
 * Created by Chathuri
 * */

@Document
public class Grade implements Serializable {

    @Id
    private String id;

    @Indexed(name = "examId_idx", background = true)
    private String examId;

    @Indexed(name = "studentId_idx", background = true)
    private String studentId;
    private String grade;
    private String status;
    private List<StudentsAnswers> studentsAnswers;
    private int correct_answer_count;
    private int questions_count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<StudentsAnswers> getStudentsAnswers() {
        return studentsAnswers;
    }

    public void setStudentsAnswers(List<StudentsAnswers> studentsAnswers) {
        this.studentsAnswers = studentsAnswers;
    }

    public int getCorrect_answer_count() {
        return correct_answer_count;
    }

    public void setCorrect_answer_count(int correct_answer_count) {
        this.correct_answer_count = correct_answer_count;
    }

    public int getQuestions_count() {
        return questions_count;
    }

    public void setQuestions_count(int questions_count) {
        this.questions_count = questions_count;
    }
}
