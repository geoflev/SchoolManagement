package com.geoflev.educationalsystemweb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleStudentIdException(StudentUsernameException ex, WebRequest request){
        StudentUsernameExceptionResponse studentIdExceptionResponse = new StudentUsernameExceptionResponse(ex.getMessage());
        return new ResponseEntity<>(studentIdExceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleTeacherException(TeacherUsernameException ex, WebRequest request){
        TeacherUsernameExceptionResponse teacherUsernameExceptionResponse = new TeacherUsernameExceptionResponse(ex.getMessage());
        return new ResponseEntity<>(teacherUsernameExceptionResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleCourseException(CourseCodeException ex, WebRequest request){
        CourseCodeExceptionResponse courseCodeExceptionResponse = new CourseCodeExceptionResponse(ex.getMessage());
        return new ResponseEntity<>(courseCodeExceptionResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleAssignmentException(AssignmentCodeException ex, WebRequest request){
        AssignmentCodeExceptionResponse assignmentCodeExceptionResponse = new AssignmentCodeExceptionResponse(ex.getMessage());
        return new ResponseEntity<>(assignmentCodeExceptionResponse,HttpStatus.BAD_REQUEST);
    }


}
