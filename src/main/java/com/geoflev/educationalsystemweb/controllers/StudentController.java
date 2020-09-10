package com.geoflev.educationalsystemweb.controllers;

import com.geoflev.educationalsystemweb.entities.Student;
import com.geoflev.educationalsystemweb.services.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.geoflev.educationalsystemweb.services.StudentService;

import javax.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("/create")
    public ResponseEntity<?> createNewStudent(@Valid @RequestBody Student student, BindingResult result){

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null){
            return errorMap;
        }
        Student newStudent = studentService.saveOrUpdateStudent(student);
        return new ResponseEntity<Student>(newStudent, HttpStatus.CREATED);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getStudentByUsername(@PathVariable String username){
        Student student = studentService.findByUsername(username);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Student> getAllStudents(){
        return studentService.findAllStudents();
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteStudent(@PathVariable String username){
        studentService.deleteByUsername(username);
        return new ResponseEntity<String>("Student with username '" +username+
                                            "' was deleted successfully",HttpStatus.OK);
    }

}
