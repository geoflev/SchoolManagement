package com.geoflev.educationalsystemweb.controllers;

import com.geoflev.educationalsystemweb.entities.Course;
import com.geoflev.educationalsystemweb.services.CourseService;
import com.geoflev.educationalsystemweb.services.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("/create")
    public ResponseEntity<?> createNewCourse(@Valid Course course, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null) {
            return errorMap;
        }

        Course newCourse = courseService.saveOrUpdateCourse(course);
        return new ResponseEntity<Course>(newCourse, HttpStatus.CREATED);
    }

    @GetMapping("/{courseCode}")
    public ResponseEntity<?> getCourseByCode(@PathVariable String courseCode) {
        Course course = courseService.findByCode(courseCode);
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Course> getAllCourses() {
        return courseService.findAllCourses();
    }

    @DeleteMapping("/{courseCode}")
    public ResponseEntity<?> deleteCourseByCode(@PathVariable String courseCode) {
        courseService.deleteCourseByCode(courseCode);
        return new ResponseEntity<String>("Course with code: " + courseCode + " deleted successfully", HttpStatus.OK);
    }


}
