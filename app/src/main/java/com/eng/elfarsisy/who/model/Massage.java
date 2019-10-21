package com.eng.elfarsisy.who.model;

import com.google.firebase.database.ServerValue;

public class Massage {

   private String massageTxt;
    private String userId;
    private String userImage;
    private String userName;
    Object timeStamp;

    public Massage() {
    }

    public Massage(String massageTxt, String userId) {
        this.massageTxt = massageTxt;
        this.userId = userId;
        this.userImage = userImage;
        this.userName = userName;
        this.timeStamp = ServerValue.TIMESTAMP;
    }

    public String getMassageTxt() {
        return massageTxt;
    }

    public void setMassageTxt(String massageTxt) {
        this.massageTxt = massageTxt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Object getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Object timeStamp) {
        this.timeStamp = timeStamp;
    }
}
