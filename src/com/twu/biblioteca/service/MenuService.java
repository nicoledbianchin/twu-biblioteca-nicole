package com.twu.biblioteca.service;

import com.twu.biblioteca.domain.Book;

import java.util.ArrayList;

public class MenuService {
    private LibraryService libraryService = new LibraryService();


    public ArrayList<Book> getListOfBooks() {
        return libraryService.getListOfBooks();
    }
}
