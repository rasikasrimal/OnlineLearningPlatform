package com.lms.repository.impl;

import com.lms.model.Exam;
import com.lms.model.StudentsExams;
import com.lms.repository.ExamRepositoryExtended;
import com.lms.repository.StudentsExamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by Chathuri
 * */

public class ExamRepositoryImpl implements ExamRepositoryExtended {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private StudentsExamsRepository studentsExamsRepository;

    @Override
    public List<Exam> getExamByTeacher(String teacherId) {
        Query query = new Query();
        Criteria criteria = new Criteria("teacherId").is(teacherId);
        query.addCriteria(criteria);
        return mongoTemplate.find(query, Exam.class);
    }

    @Override
    public List<Exam> getAssignExamByStudentID(String studentId) {
        List<StudentsExams> studentsExams = studentsExamsRepository.getAssignExamByStudentID(studentId);
        List<Exam> exams = new ArrayList<>();

        for (StudentsExams assignExam : studentsExams) {
            Exam exam = mongoTemplate.findById(assignExam.getExamId(), Exam.class);
            exams.add(exam);
        }

        return exams;
    }

    @Override
    public List<Exam> getFinishedExamByStudentID(String studentId) {
        List<StudentsExams> studentsExams =  studentsExamsRepository.getFinishedExamByStudentID(studentId);

        List<Exam> exams = new ArrayList<>();

        for (StudentsExams assignExam : studentsExams) {
            Exam exam = mongoTemplate.findById(assignExam.getExamId(), Exam.class);
            exams.add(exam);
        }

        return exams;
    }

    @Override
    public Exam findExamById(String id) {
        return mongoTemplate.findById(id, Exam.class);
    }
}
