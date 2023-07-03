package com.cs.inheritance;

public class SchoolStudent extends Student{
    public SchoolStudent(Name fullName, String id, String schoolName) {
        super(fullName, id);
        this.schoolName = schoolName;
    }

    public SchoolStudent(String schoolName) {
        this.schoolName = schoolName;
    }

    String schoolName;
}
