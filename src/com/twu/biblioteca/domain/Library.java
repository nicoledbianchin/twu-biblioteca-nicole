package com.twu.biblioteca.domain;

import java.util.ArrayList;

public class Library {

    ArrayList<Book> listOfBooks = new ArrayList();

    public Library() {
        listOfBooks.add(new Book("Harry Potter and the Philosopher's Stone"));
    }

    public ArrayList<Book> getListOfBooks() {
        return listOfBooks;
    }
}
