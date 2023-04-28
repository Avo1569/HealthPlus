package com.example.healthplus;

public class BookingDataClass {
    private String dataDocName;
    private String dataDate;
    private String dataTime;
    private String dataImage;

    public String getDataImage() {
        return dataImage;
    }

    private String key;

    public String getKey() {
        return key;
    }

    public String getDataDocName() {
        return dataDocName;
    }

    public String getDataDate() {
        return dataDate;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public BookingDataClass(String dataDoc, String dataDate, String dataTime, String dataImage) {
        this.dataDocName = dataDoc;
        this.dataDate = dataDate;
        this.dataTime = dataTime;
        this.dataImage = dataImage;
    }
    public BookingDataClass(){

    }
}