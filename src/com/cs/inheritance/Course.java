package com.cs.inheritance;

public class Course {
    String courseID;
    String courseName;

    public Course(String courseName) {
        this.courseID = java.util.UUID.randomUUID().toString();;
        this.courseName = courseName;
    }

}
