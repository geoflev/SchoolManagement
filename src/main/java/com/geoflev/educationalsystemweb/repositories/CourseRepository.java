package com.geoflev.educationalsystemweb.repositories;

import com.geoflev.educationalsystemweb.entities.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {

    Course findByCourseId(Long courseId);

    Course findCourseByCourseCode(String courseCode);

    @Override
    Iterable<Course> findAll();
}
