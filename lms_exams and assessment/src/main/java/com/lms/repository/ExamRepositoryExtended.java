package com.lms.repository;

import com.lms.model.Exam;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Created by Chathuri
 * */

//@Repository

public interface ExamRepositoryExtended {

    List<Exam> getExamByTeacher(String teacherId);

    List<Exam> getAssignExamByStudentID(String studentId);

    List<Exam> getFinishedExamByStudentID(String studentId);

    Exam findExamById(String id);
}
