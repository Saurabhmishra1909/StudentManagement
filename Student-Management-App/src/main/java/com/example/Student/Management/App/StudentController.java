package com.example.Student.Management.App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/get-all")
    public ResponseEntity<List<String>> getAllStudents() {
        List<String> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PutMapping("/add-Teacher-Student")
    public ResponseEntity<String>addStudentTeacher(@RequestParam Integer teacherId,@RequestParam Integer studentId){
        String status=studentService.addStudentTeacher(teacherId,studentId);
        return new ResponseEntity<>(status,HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-teacherStudentPair")
    public ResponseEntity<List<String>>putStudentTeacher(@RequestParam Integer teacherId){
        List<String>student=studentService.putStudentTeacher(teacherId);
        return new ResponseEntity<>(student,HttpStatus.FOUND);
    }

    @DeleteMapping("/del-teacher/{name}")
    public ResponseEntity<String>deleteTeacher(@PathVariable("name") String name){
        String status=studentService.deleteTeacher(name);
        return new ResponseEntity<>(status,HttpStatus.ACCEPTED);
    }

}
