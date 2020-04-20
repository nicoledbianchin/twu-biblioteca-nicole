package com.twu.biblioteca.service;

import com.twu.biblioteca.domain.objects.User;
import com.twu.biblioteca.domain.objectsCuration.Login;

import java.util.ArrayList;

public class UserService {
    private Login login = new Login();

    public String askForLogin() {
        return "Please, tell us your name:";
    }

    public ArrayList<User> getListOfUsers() {
        return login.getlistOfUsers();
    }
}
