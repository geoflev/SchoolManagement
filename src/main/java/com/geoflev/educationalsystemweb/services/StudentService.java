package com.geoflev.educationalsystemweb.services;

import com.geoflev.educationalsystemweb.entities.Student;
import com.geoflev.educationalsystemweb.exceptions.StudentUsernameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.geoflev.educationalsystemweb.repositories.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveOrUpdateStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findByUsername(String username) {
        Student student = studentRepository.findStudentByUsername(username);
        if (student == null) {
            throw new StudentUsernameException("Student with username: '" + username + "' does not exist");
        }
        return student;
    }

    public Iterable<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public void deleteByUsername(String username) {
        Student student = studentRepository.findStudentByUsername(username);
        if (student == null) {
            throw new StudentUsernameException("This student does not exist");
        }
        studentRepository.delete(student);
    }
}
