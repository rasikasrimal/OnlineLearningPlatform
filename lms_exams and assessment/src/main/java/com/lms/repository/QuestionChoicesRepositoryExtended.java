package com.lms.repository;

/*
 * Created by Chathuri
 * */

import com.lms.model.QuestionChoices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

//@Repository

public interface QuestionChoicesRepositoryExtended {

    QuestionChoices getChoiceByIdAndExamIdandQuestionId(String id, String examId, String questionId);
}
