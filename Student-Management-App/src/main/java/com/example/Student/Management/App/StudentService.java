package com.example.Student.Management.App;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public Student getStudent(int admNo){
        return  studentRepository.getStudent(admNo);
    }

    public String addStudent(Student student) {
        studentRepository.addStudent(student);
        return "Added Successfully";
    }

    public Teacher getTeacher(int id){
        return studentRepository.getTeacher(id);
    }

    public Teacher getTeacherName(String name){
        return studentRepository.getTeacherName(name);
    }

    public String addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
        return "Teacher Added";
    }
    public List<String> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public String deleteTeacher(String name){
        return studentRepository.deleteTeacher(name);
    }

    public String addStudentTeacher(Integer teacherId, Integer studentId) {
        return studentRepository.addStudentTeacher(teacherId,studentId);
    }

    public List<String> putStudentTeacher(Integer teacherId) {
        return studentRepository.putStudentTeacher(teacherId);
    }
}
