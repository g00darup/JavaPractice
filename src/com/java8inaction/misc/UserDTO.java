package com.java8inaction.misc;

public class UserDTO {


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserDTO(int id, String usrName, String email) {
        this.id = id;
        this.usrName = usrName;
        this.email = email;
    }

    private int id;
    private String usrName;
    private String email;


}
