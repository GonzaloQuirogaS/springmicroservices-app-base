package com.microservice.course.service.interfaces;

import com.microservice.course.http.response.StudentsByCourseResponse;
import com.microservice.course.persistence.entity.Course;

import java.util.List;

public interface ICourseService {

    List<Course> findAll();

    Course findById(Long id);

    void save(Course course);

    StudentsByCourseResponse findStudentsByIdCourse(Long idCourse);

}
