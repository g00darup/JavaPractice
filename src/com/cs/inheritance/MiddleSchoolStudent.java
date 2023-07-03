package com.cs.inheritance;

public class MiddleSchoolStudent extends SchoolStudent{
    public MiddleSchoolStudent(Name fullName, String id, String schoolName) {
        super(fullName, id, schoolName);
    }

    public MiddleSchoolStudent(String schoolName) {
        super(schoolName);
    }
}
