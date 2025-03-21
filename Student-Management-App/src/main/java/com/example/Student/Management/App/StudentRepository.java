package com.example.Student.Management.App;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {
    Map<Integer, Student> studentDB = new HashMap<>();

    public Student getStudent(int admNo) {
        // Use studentDB.get(admNo) to retrieve the student
        return studentDB.get(admNo);
    }
    public void addStudent(Student student) {
        studentDB.put(student.getAdmNo(), student);
    }
}

