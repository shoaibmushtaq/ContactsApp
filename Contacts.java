package com.example.muhammadshoaib.contactsapp;

import android.graphics.Bitmap;

public class Contacts {

    private String name;
    private String phone;
    private Bitmap image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {

        this.image = image;

    }
}
