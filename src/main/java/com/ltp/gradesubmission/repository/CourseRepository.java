package com.ltp.gradesubmission.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ltp.gradesubmission.entity.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {

    Optional<Course> findByCode(String courseCode);
}