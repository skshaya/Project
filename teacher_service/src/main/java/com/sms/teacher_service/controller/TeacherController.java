package com.sms.teacher_service.controller;

import com.sms.teacher_service.model.Teacher;
import com.sms.teacher_service.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/services")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "Hi, This is my SMS Project";
    }

    @RequestMapping(value = "/teacher/save",method = RequestMethod.POST)
    public Teacher saveTeacher(@RequestBody Teacher teacher){
        return teacherService.saveTeacher(teacher);
    }

    @RequestMapping(value = "/teacher/{id}")
    public Optional<Teacher> getTeacherById(@PathVariable("id") int id){
        return teacherService.findById(id);
    }

    @RequestMapping(value = "/teacher/update/{id}")
    public Teacher updateTeacher(@PathVariable("id") int id, @RequestBody Teacher teacher){
        return teacherService.updateTeacher(id, teacher);
    }
}

