package com.ltp.gradesubmission.service;

import java.util.Set;

import com.ltp.gradesubmission.dtos.CourseDTO;
import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Student;

public interface CourseService {
    Course getCourse(Long id);

    Course getCourseByCode(String courseCode);

    Course saveCourse(Course course);

    void deleteCourse(Long id);

    CourseDTO getCourses(int pageNumber, int sizePerPage);

    Course addStudentToCourse(Long studentId, String courseCode);

    Set<Student> getEnrolledStudents(Long id);

}