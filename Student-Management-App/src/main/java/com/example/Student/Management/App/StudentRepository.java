package com.example.Student.Management.App;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {
    Map<Integer, Student> studentDB = new HashMap<>();
    Map<Integer, Teacher> teacherDB = new HashMap<>();

    public Student getStudent(int admNo) {
        // Use studentDB.get(admNo) to retrieve the student
        return studentDB.get(admNo);
    }
    public void addStudent(Student student) {
        studentDB.put(student.getAdmNo(), student);
    }

    public Teacher getTeacher(int id) {
        return teacherDB.get(id);
    }

    public Teacher getTeacherName(String name){
        for(Integer teacherId:teacherDB.keySet()){
            if(teacherDB.get(teacherId).getName().equals(name)) return teacherDB.get(teacherId);
        }return null;
    }

    public void addTeacher(Teacher teacher){
        teacherDB.put(teacher.getId(), teacher);
    }
}

