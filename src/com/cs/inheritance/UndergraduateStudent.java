package com.cs.inheritance;

public class UndergraduateStudent extends CollegeStudent{
    private String degree;
    protected String name;
    protected String id;

    public UndergraduateStudent(Name name, String id) {
        super(name, id);
    }
}
