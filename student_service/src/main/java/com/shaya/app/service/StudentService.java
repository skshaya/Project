package com.shaya.app.service;

import com.shaya.app.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudent();
    Optional<Student> findById(Integer id);
    Student updateStudent(Integer id, Student student1);

}
