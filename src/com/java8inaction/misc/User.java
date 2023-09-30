package com.java8inaction.misc;

public class User {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(int id, String usrName, String pwd, String email) {
        this.id = id;
        this.usrName = usrName;
        this.pwd = pwd;
        this.email = email;
    }

    private int id;
    private String usrName;
    private String pwd;
    private String email;

}
