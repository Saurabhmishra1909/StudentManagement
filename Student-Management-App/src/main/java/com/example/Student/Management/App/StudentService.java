package com.example.Student.Management.App;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
