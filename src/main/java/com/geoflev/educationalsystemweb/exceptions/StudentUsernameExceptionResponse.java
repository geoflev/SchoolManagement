package com.geoflev.educationalsystemweb.exceptions;

public class StudentUsernameExceptionResponse {

    private String username;

    public StudentUsernameExceptionResponse(String username){
        this.username = username;
    }

    public String getStudentUsername(){
        return username;
    }

    public void setStudentUsername(String username){
        this.username = username;
    }
}
