package com.cs.inheritance;

public class StudentDriver {

    public static void main(String[] args) {
        Student hs = new HighSchoolStudent(new Name("Name","High"),"123","Alpha Beta");
        Student ms = new MiddleSchoolStudent(new Name("Name","Middle"),"234","Gamma Beta");
        display(hs);
        display(ms);
    }

    public static void display(Student st) {
        System.out.println(st.toString());
    }
}
