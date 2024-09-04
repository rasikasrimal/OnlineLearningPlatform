package com.lms.repository;

/*
 * Created by Chathuri
 * */

import com.lms.model.Grade;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository

public interface GradeRepositoryExtended {

    List<Grade> getGradeByStudentAndExam(String studentId, String examId);

}
