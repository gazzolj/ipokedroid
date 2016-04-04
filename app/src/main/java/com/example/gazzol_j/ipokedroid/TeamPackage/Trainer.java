package com.example.gazzol_j.ipokedroid.TeamPackage;

import java.io.Serializable;

public class Trainer implements Serializable {
    String name;
    String picture;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
