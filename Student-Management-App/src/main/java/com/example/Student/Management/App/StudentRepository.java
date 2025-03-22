package com.example.Student.Management.App;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {
    Map<Integer, Student> studentDB = new HashMap<>();
    Map<Integer, Teacher> teacherDB = new HashMap<>();
    Map<Integer,List<Integer>>teacherStudentDB=new HashMap<>();

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
        teacherStudentDB.put(teacher.getId(),new ArrayList<>());
    }

    public List<String> getAllStudents() {
        List<String> studentNames = new ArrayList<>();
        for (Integer id : studentDB.keySet()) {
            studentNames.add("name: "+studentDB.get(id).getName()+" id: "+id);
        }
        return studentNames;
    }


    public String deleteTeacher(String name){
        int teacherID=-1;
        for(int i:teacherDB.keySet()){
            if(teacherDB.get(i).getName().equals(name)){
                teacherID=i;
            }
        }
        if(teacherID!=-1){
            teacherDB.remove(teacherID);
            teacherStudentDB.remove(teacherID);
            return "Teacher "+name+ "Removed";
        }
        return "Teacher Not Found";
    }

    public String addStudentTeacher(Integer teacherId, Integer studentId) {
        if(teacherDB.containsKey(teacherId)&&studentDB.containsKey(studentId)){
            if(!teacherStudentDB.containsKey(teacherId)){
                teacherStudentDB.put(teacherId,new ArrayList<>());
            }
            teacherStudentDB.get(teacherId).add(studentId);
        }
        if(!teacherDB.containsKey(teacherId)) return "There ain't any teacher with such Id";
        if(!studentDB.containsKey(studentId)) return "There ain't any student with such Id";
        return "Pair "+teacherId+ "-"+studentId+" added";
    }

    public List<String> putStudentTeacher(Integer teacherId) {
        List<Integer>studentId=teacherStudentDB.get(teacherId);
        List<String>student=new ArrayList<>();
        if(studentId==null)  return new ArrayList<>(Collections.singletonList("No Record Found"));
        for(int id:studentId){
            student.add(studentDB.get(id).getName());
        }
        return student;
    }
}

