package com.example.Student.Management.App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RequestMapping("/student")
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/get-student")
    public ResponseEntity<Student> getStudent(@RequestParam("id") Integer admNo) {
        Student student= studentService.getStudent(admNo);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    @GetMapping("/get-student/{id}")
    public ResponseEntity<Student> getStudentByPath(@PathVariable("id") Integer admNo){
        Student student= studentService.getStudent(admNo);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }
    @PostMapping("/add-student")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        String s= studentService.addStudent(student);
        return new ResponseEntity<>(s,HttpStatus.CREATED);
    }

    @PostMapping("/add-teacher")
    public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher){
        String t= studentService.addTeacher(teacher);
        return new ResponseEntity<>(t,HttpStatus.CREATED);
    }

    @GetMapping("/get-teacher-name/{name}")
    public ResponseEntity<Teacher> getTeacherName(@PathVariable("name") String name){
        Teacher teacher=studentService.getTeacherName(name);
        return new ResponseEntity<>(teacher,HttpStatus.FOUND);
    }

    @GetMapping("/get-teacher/{id}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable("id") int id){
        Teacher teacher=studentService.getTeacher(id);
        return new ResponseEntity<>(teacher,HttpStatus.OK);
    }
}
