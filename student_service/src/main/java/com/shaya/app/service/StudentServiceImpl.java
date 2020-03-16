package com.shaya.app.service;

import com.shaya.app.model.Student;
import com.shaya.app.model.Telephone;
import com.shaya.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public List<Student> getAllStudent(){
        List<Student> students = new ArrayList<>();
         students=studentRepository.findAll();
        return students;
    }

    public Optional<Student> findById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student updateStudent(Integer id, Student student1) {
        Student student = studentRepository.findById(id).get();
        student.setFirstname(student1.getFirstname());
        student.setLastname(student1.getLastname());
        student.setStudentclass(student1.getStudentclass());
        student.setAddress(student1.getAddress());
        student.setTelephones(student1.getTelephones());
        student.setLogin(student1.getLogin());
        return studentRepository.save(student);
    }
}
