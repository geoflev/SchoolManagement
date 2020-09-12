package com.geoflev.educationalsystemweb.exceptions;

public class AssignmentCodeExceptionResponse {

    private String courseCode;

    public AssignmentCodeExceptionResponse(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getAssignmentCode() {
        return courseCode;
    }

    public void setAssignmentCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
