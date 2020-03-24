package com.shaya.app.controller;

import com.shaya.app.model.Student;
import com.shaya.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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
    public Optional<Student> getStudentById(@PathVariable("id") int id){
        return studentService.findById(id);
    }

    @RequestMapping(value = "/student/update/{id}", method = RequestMethod.PUT)
    public Student updateStudent(@PathVariable("id") int id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }

    @RequestMapping(value = "/student/delete/{id}", method = RequestMethod.GET)
    public void deleteStudentById(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }

}
