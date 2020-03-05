package com.shaya.app.service;

import com.shaya.app.model.Student;
import com.shaya.app.model.Telephone;
import com.shaya.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        for (Telephone telephone: student.getTelephones()){
            telephone.setStudent(student);
        }
        return studentRepository.save(student);
    }
}
