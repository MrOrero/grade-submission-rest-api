package com.ltp.gradesubmission.dtos;

import java.util.List;

import com.ltp.gradesubmission.entity.Course;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private List<Course> courses;
    private long totalCourses;
}
