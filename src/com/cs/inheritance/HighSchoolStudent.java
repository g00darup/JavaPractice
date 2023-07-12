package com.cs.inheritance;

public class HighSchoolStudent extends SchoolStudent{
    Name fullName;
    String id;
    String schoolName;
    public HighSchoolStudent(Name fullName, String id, String schoolName) {
        super(fullName,id,schoolName);
        fullName = fullName;
        id=id;
        schoolName=schoolName;

    }


}
