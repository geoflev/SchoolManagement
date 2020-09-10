package com.geoflev.educationalsystemweb.repositories;

import com.geoflev.educationalsystemweb.entities.Assignment;
import com.geoflev.educationalsystemweb.entities.Course;
import org.springframework.data.repository.CrudRepository;

public interface AssignmentRepository extends CrudRepository<Assignment,Long> {

    Assignment findByAssignmentId(Long findByAssignmentId);

    Assignment findAssignmentByAssignmentCode(String assignmentCode);

    @Override
    Iterable<Assignment> findAll();
}
