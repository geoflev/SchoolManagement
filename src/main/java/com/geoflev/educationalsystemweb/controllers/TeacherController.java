package com.geoflev.educationalsystemweb.controllers;

import com.geoflev.educationalsystemweb.entities.Teacher;
import com.geoflev.educationalsystemweb.services.MapValidationErrorService;
import com.geoflev.educationalsystemweb.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("/create")
    public ResponseEntity<?> createNewTeacher(@Valid Teacher teacher, BindingResult result){

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null){
            return errorMap;
        }
        Teacher newTeacher = teacherService.saveOrUpdateTeacher(teacher);
        return new ResponseEntity<Teacher>(teacher, HttpStatus.CREATED);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getTeacherByUsername(@PathVariable String username){
        Teacher teacher = teacherService.findByUsername(username);
        return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Teacher> getAllTeachers(){
        return teacherService.findAllTeachers();
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteTeacherByUsername(@PathVariable  String username){
        teacherService.deleteByUsername(username);
        return new ResponseEntity<String>("Teacher with username: '" + username + "' was successfully deleted",HttpStatus.OK);
    }















}
