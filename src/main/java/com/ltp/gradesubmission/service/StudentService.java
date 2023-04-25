package com.ltp.gradesubmission.service;

import java.util.List;
import java.util.Set;

import com.ltp.gradesubmission.dtos.StudentDTO;
import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Student;

public interface StudentService {
    Student getStudent(Long id);

    Student saveStudent(Student student);

    void deleteStudent(Long id);

    StudentDTO getStudents(int page, int size);

    Set<Course> getEnrolledCourses(Long id);

}