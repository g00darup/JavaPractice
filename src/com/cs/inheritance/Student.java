package com.cs.inheritance;

import com.cs.inheritance.input.Person;

public class Student implements Person {
    public Student(Name fullName, String id) {
        this.fullName = fullName;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName=" + fullName +
                ", id=" + id  +
                '}';
    }

    public Name getFullName() {
        return fullName;
    }

    public void setFullName(Name fullName) {
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private Name fullName;
    private String id;

    public Student(){
        fullName = new Name();
    }


    @Override
    public boolean equalTo(Person other) {
        return other.equals(this);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getAge() {
        return 0;
    }
}
