package com.ltp.gradesubmission.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ltp.gradesubmission.dtos.StudentDTO;
import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.exception.EntityNotFoundException;
import com.ltp.gradesubmission.repository.StudentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;

    @Override
    public Student getStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return unwrapStudent(student, id);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDTO getStudents(int pageNumber, int sizePerPage) {
        // Create a PageRequest object with the pageNumber, sizePerPage, and sorting if
        // needed
        PageRequest pageRequest = PageRequest.of(pageNumber, sizePerPage);

        // Fetch the page of students using the pageRequest
        Page<Student> studentsPage = studentRepository.findAll(pageRequest);

        // Extract the list of students from the page
        List<Student> students = studentsPage.getContent();

        long totalStudents = studentsPage.getTotalElements();

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudents(students);
        studentDTO.setTotalStudents(totalStudents);

        return studentDTO;
    }

    @Override
    public Set<Course> getEnrolledCourses(Long id) {
        Student student = getStudent(id);
        return student.getCourses();
    }

    static Student unwrapStudent(Optional<Student> entity, Long id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new EntityNotFoundException(id, Student.class);
    }

}