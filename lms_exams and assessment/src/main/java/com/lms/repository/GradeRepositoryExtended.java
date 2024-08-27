package com.lms.repository;

/*
 * Created by Chathuri
 * */

import com.lms.model.Grade;

import java.util.List;

public interface GradeRepositoryExtended {

    List<Grade> getGradeByStudentAndExam(String studentId, String examId);

}
