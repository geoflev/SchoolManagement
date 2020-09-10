package com.geoflev.educationalsystemweb.repositories;

import com.geoflev.educationalsystemweb.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

    Student findByStudentId(Long studentId);

    Student findStudentByUsername(String username);

    @Override
    Iterable<Student> findAll();

    
}
