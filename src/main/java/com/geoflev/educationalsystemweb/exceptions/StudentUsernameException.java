package com.geoflev.educationalsystemweb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StudentUsernameException extends RuntimeException{

    public StudentUsernameException(String message){
        super(message);
    }
}
