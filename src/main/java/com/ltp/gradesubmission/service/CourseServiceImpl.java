package com.ltp.gradesubmission.service;

import java.util.List;
import java.util.Set;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ltp.gradesubmission.dtos.CourseDTO;
import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.exception.EntityNotFoundException;
import com.ltp.gradesubmission.repository.CourseRepository;
import com.ltp.gradesubmission.repository.StudentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    CourseRepository courseRepository;
    StudentRepository studentRepository;

    @Override
    public Course getCourse(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        return unwrapCourse(course, id);
    }

    @Override
    public Course getCourseByCode(String courseCode) {
        Optional<Course> course = courseRepository.findByCode(courseCode);
        return unwrapCourse(course, courseCode);
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public CourseDTO getCourses(int pageNumber, int sizePerPage) {
        PageRequest pageRequest = PageRequest.of(pageNumber, sizePerPage);

        // Fetch the page of students using the pageRequest
        Page<Course> coursesPage = courseRepository.findAll(pageRequest);

        // Extract the list of students from the page
        List<Course> courses = coursesPage.getContent();

        long totalCourses = coursesPage.getTotalElements();

        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourses(courses);
        courseDTO.setTotalCourses(totalCourses);

        return courseDTO;
    }

    @Override
    public Course addStudentToCourse(Long studentId, String courseCode) {
        Course course = getCourseByCode(courseCode);
        Optional<Student> student = studentRepository.findById(studentId);
        Student unwrappedStudent = StudentServiceImpl.unwrapStudent(student,
                studentId);
        course.getStudents().add(unwrappedStudent);
        return courseRepository.save(course);
    }

    @Override
    public Set<Student> getEnrolledStudents(Long id) {
        Course course = getCourse(id);
        return course.getStudents();
    }

    static Course unwrapCourse(Optional<Course> entity, Long id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new EntityNotFoundException(id, Course.class);
    }

    static Course unwrapCourse(Optional<Course> entity, String courseCode) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new EntityNotFoundException(courseCode, Course.class);
    }

}
