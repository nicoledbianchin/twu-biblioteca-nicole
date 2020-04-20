package com.twu.biblioteca.domain.objectsCuration;

import com.twu.biblioteca.domain.objects.User;

import java.util.ArrayList;

public class Login {
    private ArrayList<User> listOfUsers = new ArrayList<>();

    public Login () {
        listOfUsers.add(new User("Trixie"));
    }

    public ArrayList<User> getlistOfUsers() {
        return listOfUsers;
    }
}
