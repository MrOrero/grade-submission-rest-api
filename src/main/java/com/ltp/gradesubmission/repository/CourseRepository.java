package com.ltp.gradesubmission.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ltp.gradesubmission.entity.Course;

public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {

    Optional<Course> findByCode(String courseCode);
}