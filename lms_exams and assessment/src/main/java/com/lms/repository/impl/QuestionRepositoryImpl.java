package com.lms.repository.impl;

/*
 * Created by Chathuri
 * */

import com.lms.model.Question;
import com.lms.repository.QuestionRepositoryExtended;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class QuestionRepositoryImpl implements QuestionRepositoryExtended {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Question> findQuestionByExamId(String examId) {
        Query query = new Query();
        Criteria criteria = new Criteria("examid").is(examId);
        query.addCriteria(criteria);
        return mongoTemplate.find(query, Question.class);
    }
}
