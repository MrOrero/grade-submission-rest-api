package com.ltp.gradesubmission.service;

import java.util.List;
import java.util.Set;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Student;

public interface CourseService {
    Course getCourse(Long id);

    Course saveCourse(Course course);

    void deleteCourse(Long id);

    List<Course> getCourses();

    Course addStudentToCourse(Long studentId, Long courseId);

    Set<Student> getEnrolledStudents(Long id);

}