package com.lms.repository;

/*
 * Created by Chathuri
 * */

import com.lms.model.QuestionChoices;



public interface QuestionChoicesRepositoryExtended {

    QuestionChoices getChoiceByIdAndExamIdandQuestionId(String id, String examId, String questionId);
}
