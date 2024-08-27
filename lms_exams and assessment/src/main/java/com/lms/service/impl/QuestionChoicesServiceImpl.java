package com.lms.service.impl;


import com.lms.repository.QuestionChoicesRepository;
import com.lms.model.QuestionChoices;
import com.lms.service.QuestionChoicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Created by Chathuri
 * */

@Service
public class QuestionChoicesServiceImpl implements QuestionChoicesService {

    @Autowired
    private QuestionChoicesRepository questionChoicesRepository;

    @Override
    public QuestionChoices getChoiceByIdAndExamIdandQuestionId(String id, String examId, String questionId) {
        return questionChoicesRepository.getChoiceByIdAndExamIdandQuestionId(id, examId, questionId);
    }
}
