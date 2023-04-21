package com.ltp.gradesubmission.service;

import java.util.List;
import java.util.Set;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Student;

public interface CourseService {
    Course getCourse(Long id);

    Course getCourseByCode(String courseCode);

    Course saveCourse(Course course);

    void deleteCourse(Long id);

    List<Course> getCourses();

    Course addStudentToCourse(Long studentId, String courseCode);

    Set<Student> getEnrolledStudents(Long id);

}