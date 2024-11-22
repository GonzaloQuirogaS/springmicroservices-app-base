package com.microservice.student.service.interfaces;

import com.microservice.student.persistence.entity.Student;

import java.util.List;

public interface IStudentService {

    List<Student> findAll();

    Student findById(Long id);

    void save(Student student);

    List<Student> findByIdCourse(Long idCourse);

}
