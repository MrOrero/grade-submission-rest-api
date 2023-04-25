package com.ltp.gradesubmission.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ltp.gradesubmission.entity.Student;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
    // Page<Student> findAll(PageRequest pageRequest);
}