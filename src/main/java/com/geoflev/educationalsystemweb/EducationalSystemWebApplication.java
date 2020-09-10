package com.geoflev.educationalsystemweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class EducationalSystemWebApplication {

    public static final Logger logger = LoggerFactory.getLogger(EducationalSystemWebApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(EducationalSystemWebApplication.class, args);
    }

}
