package com.geoflev.educationalsystemweb.services;

import com.geoflev.educationalsystemweb.entities.Course;
import com.geoflev.educationalsystemweb.exceptions.CourseCodeException;
import com.geoflev.educationalsystemweb.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course saveOrUpdateCourse(Course course){
        return courseRepository.save(course);
    }

    public Course findByCode(String code){
        Course course = courseRepository.findCourseByCourseCode(code);
        if(course == null){
            throw new CourseCodeException("Course with code: '" + code + "' doesnt exist");
        }
        return course;
    }

    public Iterable<Course> findAllCourses(){
        return courseRepository.findAll();
    }

    public void deleteCourseByCode(String code){
        Course course = courseRepository.findCourseByCourseCode(code);
        if(course == null){
            throw new CourseCodeException("Course not found");
        }
        courseRepository.delete(course);
    }
}
