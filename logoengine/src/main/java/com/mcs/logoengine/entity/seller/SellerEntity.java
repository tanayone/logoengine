package com.mcs.logoengine.entity.seller;

public class SellerEntity {
    private String Pan_no;
    private String Name;
    private String State;
    private String Phone_no;
    private String Email;
    private String Username;
    private String Password;

    public SellerEntity(){}

    public String getPan_no() {
        return Pan_no;
    }

    public void setPan_no(String pan_no) {
        Pan_no = pan_no.toUpperCase();
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getPhone_no() {
        return Phone_no;
    }

    public void setPhone_no(String phone_no) {
        Phone_no = phone_no;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email.toLowerCase();
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username.toLowerCase();
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
