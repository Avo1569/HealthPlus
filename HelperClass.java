package com.example.healthplus;

public class HelperClass {
    String name, date, time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public HelperClass(String name, String date, String time) {
        this.name = name;
        this.date = date;
        this.time = time;
    }
}
