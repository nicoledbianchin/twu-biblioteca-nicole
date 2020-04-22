package com.twu.biblioteca.service;

import com.twu.biblioteca.domain.objects.Librarian;

public class LibrarianService {
    private Librarian librarian = new Librarian();

    public boolean login(int loginNumber, int password) {
        if (librarian.validateLoginNumber(loginNumber) && librarian.validatePassword(password)){
            return true;
        } else {
            return false;
        }
    }
}
