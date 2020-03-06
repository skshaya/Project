package com.sms.teacher_service.service;

import com.sms.teacher_service.model.Teacher;

import java.util.Optional;

public interface TeacherService {
    Teacher saveTeacher(Teacher teacher);
    Optional<Teacher> findById(Integer id);
    Teacher updateTeacher(Integer id, Teacher teacher);


}
