package com.cs.inheritance;

public class ElementaryStudent extends SchoolStudent{
    public ElementaryStudent(Name fullName, String id, String schoolName) {
        super(fullName, id, schoolName);
    }

    public ElementaryStudent(String schoolName) {
        super(schoolName);
    }
}
