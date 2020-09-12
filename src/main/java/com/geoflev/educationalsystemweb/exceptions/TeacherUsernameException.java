package com.geoflev.educationalsystemweb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TeacherUsernameException extends RuntimeException {

    public TeacherUsernameException(String message) {
        super(message);
    }
}
