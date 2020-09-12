package com.geoflev.educationalsystemweb.services;

import com.geoflev.educationalsystemweb.entities.Assignment;
import com.geoflev.educationalsystemweb.exceptions.AssignmentCodeException;
import com.geoflev.educationalsystemweb.repositories.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    public Assignment saveOrUpdateAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public Assignment findByCode(String code) {
        Assignment assignment = assignmentRepository.findAssignmentByAssignmentCode(code);
        if (assignment == null) {
            throw new AssignmentCodeException("Assignment with code: '" + code + "' doesnt exist");
        }
        return assignment;
    }

    public Iterable<Assignment> findAllAssignments() {
        return assignmentRepository.findAll();
    }

    public void deleteAssignmentByCode(String code) {
        Assignment assignment = assignmentRepository.findAssignmentByAssignmentCode(code);
        if (assignment == null) {
            throw new AssignmentCodeException("Assignment not found!");
        }
        assignmentRepository.delete(assignment);
    }
}
