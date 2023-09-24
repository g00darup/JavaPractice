package com.cs.inheritance;

public class CollegeStudent extends Student{
    private int year;

    public CollegeStudent(Name name, String id) {
        super(name, id);
    }
    private String degree;
    protected String name;
    protected String id;

//    public CollegeStudent(){
//        super("name","id");
//        year = 0;
//        degree = "";
//    }
}
