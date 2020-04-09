package com.twu.biblioteca.domain;

import java.util.ArrayList;

public class Library {

    ArrayList<Book> listOfBooks = new ArrayList();

    public Library() {
        listOfBooks.add(new Book("Harry Potter and the Philosopher's Stone"));
        listOfBooks.add(new Book("Harry Potter and the Chamber of Secrets"));
        listOfBooks.add(new Book("Harry Potter and the Prisioner of Azkaban"));
        listOfBooks.add(new Book("Harry Potter and the Glober of Fire"));
        listOfBooks.add(new Book("Harry Potter and the Order of the Phoenix"));
        listOfBooks.add(new Book("Harry Potter and the Half-Blood Prince"));
        listOfBooks.add(new Book("Harry Potter and the Deathly Hollows"));
    }

    public ArrayList<Book> getListOfBooks() {
        return listOfBooks;
    }
}
