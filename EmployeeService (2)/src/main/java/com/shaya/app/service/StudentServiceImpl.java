package com.shaya.app.service;

import com.shaya.app.model.Student;
import com.shaya.app.model.Telephone;
import com.shaya.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public Optional<Student> findById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student updateStudent(Integer id, Student student) {
        Student student1 = studentRepository.findById((id)).get();
        student1.setFirstname(student.getFirstname());
        student1.setLastname(student.getLastname());
        student1.setAddress(student.getAddress());
        student1.setLogin(student.getLogin());
        student1.setTelephones(student.getTelephones());
        return studentRepository.save(student1);

    }
}
