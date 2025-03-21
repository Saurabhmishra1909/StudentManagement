package com.example.Student.Management.App;

public class Student {
    private int admNo;
    private String course;
    private String name;
    private int age;

    public Student() {
    }

    public Student(int admNo, String course, String name, int age) {
        this.admNo = admNo;
        this.course = course;
        this.name = name;
        this.age = age;
    }

    public int getAdmNo() {
        return admNo;
    }

    public void setAdmNo(int admNo) {
        this.admNo = admNo;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
