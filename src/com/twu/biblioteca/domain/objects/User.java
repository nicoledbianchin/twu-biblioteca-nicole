package com.twu.biblioteca.domain.objects;

public class User {

    private String name;
    private String email;
    private int phoneNumber;

    public User(String name) {
        this.name = name;
    }

    public User(String name, String email, int phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }
}
