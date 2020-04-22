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

    public boolean validateUser(String username) {
        boolean validUser = false;
        for (User user : getListOfUsers()) {
            if (user.getUserName().equalsIgnoreCase(username)){
                validUser = true;
            } else {
                validUser = false;
            }
        }
        return validUser;
    }

    public void createNewUser(String username, String email, int phoneNumber) {
        login.addNewUser(username, email, phoneNumber);
    }
}
