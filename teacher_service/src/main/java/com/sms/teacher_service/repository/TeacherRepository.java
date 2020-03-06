package com.sms.teacher_service.repository;

import com.sms.teacher_service.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
}
