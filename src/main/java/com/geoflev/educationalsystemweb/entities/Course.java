package com.geoflev.educationalsystemweb.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    @NotBlank(message = "Course code is required")
    private String courseCode;
    @NotBlank(message = "Course name is required")
    private String name;
    @NotBlank(message = "Course description is required")
    private String description;

    public Course() {
    }

    public Course(Long courseId, String courseCode, String name, String description) {
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.name = name;
        this.description = description;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
