package com.lms.repository;

/*
 * Created by Chathuri
 * */

import com.lms.model.StudentsExams;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface StudentsExamsRepositoryExtended {

    List<StudentsExams> getAssignExamByStudentID(String studentId);

    List<StudentsExams> getFinishedExamByStudentID(String studentId);

    void updateFinishedExam(String examId, String studentId);

}
