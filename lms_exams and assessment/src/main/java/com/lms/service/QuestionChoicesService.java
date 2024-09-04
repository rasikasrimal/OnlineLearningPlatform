package com.lms.service;

/*
 * Created by Chathuri
 * */



import com.lms.model.QuestionChoices;
import org.springframework.stereotype.Service;
//@Service


public interface QuestionChoicesService {

    QuestionChoices getChoiceByIdAndExamIdandQuestionId(String id, String examId, String questionId);
}
