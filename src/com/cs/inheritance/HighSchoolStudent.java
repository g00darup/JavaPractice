package com.cs.inheritance;

public class HighSchoolStudent extends SchoolStudent{
    public HighSchoolStudent(Name fullName, String id, String schoolName) {
        super(fullName, id, schoolName);
    }

    public HighSchoolStudent(String schoolName) {
        super(schoolName);
    }
}
