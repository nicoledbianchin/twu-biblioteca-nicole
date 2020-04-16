package com.twu.biblioteca.domain;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> listOfBooks = new ArrayList();

    public Library() {
        listOfBooks.add(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling"));
        listOfBooks.add(new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling"));
        listOfBooks.add(new Book("Harry Potter and the Prisioner of Azkaban", "J.K. Rowling"));
        listOfBooks.add(new Book("Harry Potter and the Globet of Fire", "J.K. Rowling"));
        listOfBooks.add(new Book("Harry Potter and the Order of the Phoenix", "J.K. Rowling"));
        listOfBooks.add(new Book("Harry Potter and the Half-Blood Prince", "J.K. Rowling"));
        listOfBooks.add(new Book("Harry Potter and the Deathly Hollows", "J.K. Rowling"));
    }

    public ArrayList<Book> getListOfBooks() {
        return listOfBooks;
    }

}
