package com.shaya.app.controller;

import com.shaya.app.model.Student;
import com.shaya.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:8091")
@RestController
@RequestMapping("/services")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "hello";
    }

    @GetMapping("/student")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @RequestMapping(value = "/student/save",method = RequestMethod.POST)
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @RequestMapping(value = "/student/{id}")
    public Optional<Student> getCustomerById(@PathVariable("id") int id){
        return studentService.findById(id);
    }

    @RequestMapping(value = "/student/update/{id}")
    public Student updateCustomer(@PathVariable("id") int id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }
}
