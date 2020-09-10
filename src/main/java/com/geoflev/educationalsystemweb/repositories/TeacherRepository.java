package com.geoflev.educationalsystemweb.repositories;

import com.geoflev.educationalsystemweb.entities.Student;
import com.geoflev.educationalsystemweb.entities.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher,Long> {

    Teacher findByTeacherId(Long teacherId);

    Teacher findTeacherByUsername(String username);

    @Override
    Iterable<Teacher> findAll();
}
