package com.geoflev.educationalsystemweb.services;

import com.geoflev.educationalsystemweb.entities.Teacher;
import com.geoflev.educationalsystemweb.exceptions.TeacherUsernameException;
import com.geoflev.educationalsystemweb.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher saveOrUpdateTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher findByUsername(String username) {
        Teacher teacher = teacherRepository.findTeacherByUsername(username);
        if (teacher == null) {
            throw new TeacherUsernameException("Teacher with username '" + username + "' doesnt exist");
        }
        return teacher;
    }

    public Iterable<Teacher> findAllTeachers() {
        return teacherRepository.findAll();
    }

    public void deleteByUsername(String username) {
        Teacher teacher = teacherRepository.findTeacherByUsername(username);
        if (teacher == null) {
            throw new TeacherUsernameException("This teacher does not exist");
        }
        teacherRepository.delete(teacher);
    }
}
