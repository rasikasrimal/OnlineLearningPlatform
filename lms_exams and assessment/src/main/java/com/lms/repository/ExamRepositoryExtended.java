package com.lms.repository;

import com.lms.model.Exam;

import java.util.List;

/*
 * Created by Chathuri
 * */

public interface ExamRepositoryExtended {

    List<Exam> getExamByTeacher(String teacherId);

    List<Exam> getAssignExamByStudentID(String studentId);

    List<Exam> getFinishedExamByStudentID(String studentId);

    Exam findExamById(String id);
}
