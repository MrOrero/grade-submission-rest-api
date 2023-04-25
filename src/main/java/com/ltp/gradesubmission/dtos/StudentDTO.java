package com.ltp.gradesubmission.dtos;

import java.util.List;

import lombok.*;

import com.ltp.gradesubmission.entity.Student;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private List<Student> students;
    private long totalStudents;
}
