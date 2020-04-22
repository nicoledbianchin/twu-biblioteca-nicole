package com.twu.biblioteca.domain.objectsCuration;

import com.twu.biblioteca.domain.objects.User;

import java.util.ArrayList;

public class Login {
    private ArrayList<User> listOfUsers = new ArrayList<>();

    public Login () {
        listOfUsers.add(new User("Trixie", "trixie@gmail.com", 1234567890));
    }

    public ArrayList<User> getlistOfUsers() {
        return listOfUsers;
    }

    public void addNewUser(String username, String email, int phoneNumber) {
        listOfUsers.add(new User(username, email, phoneNumber));
    }

    public User getUserByName(String name) {
        User userReturn = null;
        for (User user : listOfUsers) {
            if (user.getUserName().equalsIgnoreCase(name)) {
                userReturn = user;
            }
        }
        return userReturn;
    }
}
