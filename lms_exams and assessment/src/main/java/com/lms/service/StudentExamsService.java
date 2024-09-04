package com.lms.service;

import com.lms.model.Exam;
import com.lms.model.StudentsExams;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Created by Chathuri
 * */
//@Service
public interface StudentExamsService {

    StudentsExams save(StudentsExams studentsExams);

    List<StudentsExams> getAll();

    void delete(StudentsExams studentsExams);

    void updateFinishedExam(String examId, String studentId);

    List<StudentsExams> getAssignExamByStudentID(String studentId);

}
