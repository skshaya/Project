package com.sms.teacher_service.service;

import com.sms.teacher_service.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    Teacher saveTeacher(Teacher teacher);
    List<Teacher> getAllTeacher();
    Optional<Teacher> findById(Integer id);
    Teacher updateTeacher(Integer id, Teacher teacher);
    void deleteTeacher(Integer id);
}
