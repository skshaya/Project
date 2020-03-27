package com.sms.teacher_service.service;

import com.sms.teacher_service.model.Teacher;
import com.sms.teacher_service.model.Telephone;
import com.sms.teacher_service.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        for (Telephone telephone: teacher.getTelephones()){
            telephone.setTeacher(teacher);
        }
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getAllTeacher(){
        List<Teacher> teachers = new ArrayList<>();
        teachers=teacherRepository.findAll();
        return teachers;
    }

    @Override
    public Optional<Teacher> findById(Integer id) {
        return teacherRepository.findById(id);
    }

    @Override
    public Teacher updateTeacher(Integer id, Teacher teacher) {
        Teacher teacher1 = teacherRepository.findById((id)).get();
        teacher1.setFirstname(teacher.getFirstname());
        teacher1.setLastname(teacher.getLastname());
        teacher1.setAddress(teacher.getAddress());
        teacher1.setLogin(teacher.getLogin());
        teacher1.setTelephones(teacher.getTelephones());
        return teacherRepository.save(teacher1);
    }

    @Override
    public void deleteTeacher(Integer id) {
        teacherRepository.deleteById(id);
    }

}
