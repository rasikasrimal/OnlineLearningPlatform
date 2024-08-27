package com.lms.service.impl;

import com.lms.repository.ExamRepository;
import com.lms.model.Exam;
import com.lms.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Created by Chathuri
 * */

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamRepository examRepository;

    @Override
    public Exam save(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public List<Exam> getAll() {
        return null;
    }

    @Override
    public void delete(Exam exam) {

    }

    @Override
    public List<Exam> getExamByTeacher(String teacherId) {
        return examRepository.getExamByTeacher(teacherId);
    }

    @Override
    public List<Exam> getAssignExamByStudentID(String studentId) {
        return examRepository.getAssignExamByStudentID(studentId);
    }

    @Override
    public Exam findById(String id) {
        return examRepository.findExamById(id);
    }

    @Override
    public List<Exam> getFinishedExamByStudentID(String studentId) {
        return examRepository.getFinishedExamByStudentID(studentId);
    }
}
