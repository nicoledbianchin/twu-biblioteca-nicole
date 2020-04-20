package com.twu.biblioteca.domain.objects;

public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getUserName() {
        return name;
    }
}
