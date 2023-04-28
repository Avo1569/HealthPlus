package com.example.healthplus;

public class DoctorListData {
    String name, specs;
    int education, speciality, price;
    int image;

    public DoctorListData(String name, String specs, int education, int speciality, int price, int image) {
        this.name = name;
        this.specs = specs;
        this.speciality = speciality;
        this.education = education;
        this.price = price;
        this.image = image;
    }
}
