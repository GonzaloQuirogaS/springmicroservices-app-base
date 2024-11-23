package com.microservice.course.service.serviceImpl;

import com.microservice.course.client.StudentClient;
import com.microservice.course.http.response.StudentsByCourseResponse;
import com.microservice.course.persistence.entity.Course;
import com.microservice.course.persistence.repository.CourseRepository;
import com.microservice.course.presentation.dto.StudentDto;
import com.microservice.course.service.interfaces.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;

    //Cliente que se comunica con microservicio student
    @Autowired
    private StudentClient studentClient;

    @Override
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public StudentsByCourseResponse findStudentsByIdCourse(Long idCourse) {

        //Consultamos el curso
        Course course = courseRepository.findById(idCourse).orElse(new Course());

        //Obtenemos los estudiantes
        List<StudentDto> studentDtoList = studentClient.findAllStudentsByCourse(idCourse);


        return StudentsByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentList(studentDtoList)
                .build();
    }
}
