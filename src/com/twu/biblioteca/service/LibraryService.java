package com.twu.biblioteca.service;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Library;

import java.util.ArrayList;

public class LibraryService {
    private Library library = new Library();

    public ArrayList<Book> getListOfBooks() {
        return library.getListOfBooks();
    }

    public void checkOutBook(int id) {
        getListOfBooks().remove(id);
    }
}
