package com.lms.repository;

/*
 * Created by Chathuri
 * */

import com.lms.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface QuestionRepositoryExtended {

    List<Question> findQuestionByExamId(String examId);
}
