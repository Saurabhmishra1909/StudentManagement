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
}
