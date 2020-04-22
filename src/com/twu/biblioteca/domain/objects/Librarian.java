package com.twu.biblioteca.domain.objects;

public class Librarian {
    private final int loginNumber = 78781212;
    private final int password = 666;

    public boolean validateLoginNumber(int loginNumber) {
        if (loginNumber == this.loginNumber) {
            return true;
        } else {
            return false;
        }
    }


    public boolean validatePassword(int password) {
        if (password == this.password) {
            return true;
        } else {
            return false;
        }
    }
}
