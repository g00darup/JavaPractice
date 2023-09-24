package com.cs.inheritance;

public class Name {
    String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    String lastName;

    public Name(){
        firstName="";
        lastName="";
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getName(){
        return toString();
    }

    public void giveLastName(Name aName){
        aName.setLastName(lastName);
    }

    @Override
    public String toString() {
        return firstName +  " " + lastName ;
    }
}
