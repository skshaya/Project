package com.shaya.app.service;

import com.shaya.app.model.Student;

import java.util.Optional;

public interface StudentService {
    Student saveStudent(Student student);
    Optional<Student> findById(Integer id);
    Student updateStudent(Integer id, Student student);


}
