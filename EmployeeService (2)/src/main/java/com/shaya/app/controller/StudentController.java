package com.shaya.app.controller;

import com.shaya.app.model.Student;

import com.shaya.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/services")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "Hi, This is my SMS Project";
    }

    @RequestMapping(value = "/student/save",method = RequestMethod.POST)
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @RequestMapping(value = "/student/{id}")
    public Optional<Student> getStudentById(@PathVariable("id") int id){
        return studentService.findById(id);
    }

    @RequestMapping(value = "/student/update/{id}")
    public Student updateStudent(@PathVariable("id") int id,@RequestBody Student student){
        return studentService.updateStudent(id, student);
    }
}

