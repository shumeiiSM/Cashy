package com.example.a17010233.cashy;

public class Contact {
    private int mImageResource;
    private String text1;
    private String text2;

    public Contact(int mImageResource, String text1, String text2) {
        this.mImageResource = mImageResource;
        this.text1 = text1;
        this.text2 = text2;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public void setmImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }
}
