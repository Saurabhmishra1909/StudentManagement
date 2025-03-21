package com.example.Student.Management.App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RequestMapping("/student")
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/get")
    public Student getStudent(@RequestParam("id") Integer admNo) {
        return studentService.getStudent(admNo);
    }
    @GetMapping("/get/{id}")
    public Student getStudentByPath(@PathVariable("id") Integer admNo){return studentService.getStudent(admNo);}
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }
}
