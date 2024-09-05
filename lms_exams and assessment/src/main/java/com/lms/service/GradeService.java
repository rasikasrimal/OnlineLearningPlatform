package com.lms.service;


/*
 * Created by Chathuri
 * */

import com.lms.model.Exam;
import com.lms.model.Grade;

import java.util.List;

public interface GradeService {

    Grade save(Grade grade);

    List<Grade> getAll();

    void delete(Grade grade);

    Grade findById(String id);

    List<Grade> getGradeByStudentAndExam(String studentId, String examId);

}
