package com.example.lostandfoundapp.model;

import android.location.Location;

import java.util.Date;

public class Item {

    private String userName;
    private String phoneNum;
    private String description;
    private String date;
    private String location;

    public Item(String userName, String phoneNum, String description, String date, String location) {
        this.userName = userName;
        this.phoneNum = phoneNum;
        this.description = description;
        this.date = date;
        this.location = location;
    }

    public Item(){}

/*    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }*/

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getPhoneNum() { return phoneNum; }
    public void setPhoneNum(String phoneNum) { this.phoneNum = phoneNum; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
