package com.example.a17010233.cashy;

import java.io.Serializable;

public class Contact implements Serializable {
    private int mImageResource;
    private String name;
    private String phone;

    public Contact(int mImageResource, String name, String phone) {
        this.mImageResource = mImageResource;
        this.name = name;
        this.phone = phone;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public void setmImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }

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

}
