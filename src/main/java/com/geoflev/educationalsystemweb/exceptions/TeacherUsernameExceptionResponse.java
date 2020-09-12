package com.geoflev.educationalsystemweb.exceptions;

public class TeacherUsernameExceptionResponse {

    private String username;

    public TeacherUsernameExceptionResponse(String username) {
        this.username = username;
    }

    public String getTeacherUsername() {
        return username;
    }

    public void setTeacherUsername(String username) {
        this.username = username;
    }
}
