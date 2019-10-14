package com.eng.elfarsisy.who.model;

import com.google.firebase.database.ServerValue;

public class User {
    private String name;
    private String email;
    private String phone;
    private String personalimage;
    private Object stampTime;

    public User(String name, String email, String phone, String personalimage, Object stampTime) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.personalimage = personalimage;
        this.stampTime = ServerValue.TIMESTAMP;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPersonalimage() {
        return personalimage;
    }

    public void setPersonalimage(String personalimage) {
        this.personalimage = personalimage;
    }

    public Object getStampTime() {
        return stampTime;
    }

    public void setStampTime(Object stampTime) {
        this.stampTime = stampTime;
    }
}
