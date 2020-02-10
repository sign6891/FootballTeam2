package com.example.footballteam2;

public class RecyclerViewUser {

    private int imageUser;
    private String nameUser;
    private String position;

    public RecyclerViewUser(int imageUser, String nameUser, String position) {
        this.imageUser = imageUser;
        this.nameUser = nameUser;
        this.position = position;
    }

    public int getImageUser() {
        return imageUser;
    }

    public void setImageUser(int imageUser) {
        this.imageUser = imageUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
