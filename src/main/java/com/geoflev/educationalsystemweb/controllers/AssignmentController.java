package com.geoflev.educationalsystemweb.controllers;

import com.geoflev.educationalsystemweb.entities.Assignment;
import com.geoflev.educationalsystemweb.services.AssignmentService;
import com.geoflev.educationalsystemweb.services.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("/create")
    public ResponseEntity<?> createNewAssignment(@Valid @RequestBody Assignment assignment, BindingResult result){

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null){
            return errorMap;
        }
        Assignment newAssignment = assignmentService.saveOrUpdateAssignment(assignment);
        return new ResponseEntity<Assignment>(newAssignment, HttpStatus.CREATED);
    }

    @GetMapping("/{assignmentCode}")
    public ResponseEntity<?> getAssignmentByCode(@PathVariable String assignmentCode){
        Assignment assignment = assignmentService.findByCode(assignmentCode);
        return new ResponseEntity<Assignment>(assignment,HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Assignment> getAllAssignments(){
        return assignmentService.findAllAssignments();
    }

    @DeleteMapping("/{assignmentCode}")
    public ResponseEntity<?> deleteAssignmentByCode(@PathVariable String assignmentCode){
        assignmentService.deleteAssignmentByCode(assignmentCode);
        return new ResponseEntity<String>("Assignement deleted successfully", HttpStatus.OK);
    }
}













