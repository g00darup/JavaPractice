package com.cs.inheritance;

import com.cs.inheritance.input.Person;

import java.util.Objects;

public class Student implements Person {
    public Student(Name fullName, String id) {
        this.fullName = fullName;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(fullName, student.fullName) && id.equals(student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, id);
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
