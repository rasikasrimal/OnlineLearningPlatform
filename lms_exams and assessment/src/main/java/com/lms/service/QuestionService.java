package com.lms.service;

import com.lms.model.Question;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service

public interface QuestionService {

    Question save(Question question);

    List<Question> getAll();

    void delete(Question question);

    List<Question> getQuestionByTeacher(String teacherId);

    List<Question> getQuestionByStudent(String studentId);

    List<Question> findQuestionByExamId(String examId);
}
