package com.twu.biblioteca.service;

import com.twu.biblioteca.domain.objects.User;
import com.twu.biblioteca.domain.objectsCuration.Login;

import java.util.ArrayList;

public class UserService {
    private Login login = new Login();
    private OutputFormatterService outputFormatterService = new OutputFormatterService();

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

    public User getUserByName(String name) {
        return login.getUserByName(name);
    }

    public String showContactInformation(String name) {
        User user = getUserByName(name);
        return outputFormatterService.formatOutputUserInformation(user);
    }
}
