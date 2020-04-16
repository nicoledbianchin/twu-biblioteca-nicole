package com.twu.biblioteca.domain;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> listOfBooks = new ArrayList();

    public Library() {
        listOfBooks.add(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997));
        listOfBooks.add(new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", 1998));
        listOfBooks.add(new Book("Harry Potter and the Prisioner of Azkaban", "J.K. Rowling", 1999));
        listOfBooks.add(new Book("Harry Potter and the Globet of Fire", "J.K. Rowling", 2000));
        listOfBooks.add(new Book("Harry Potter and the Order of the Phoenix", "J.K. Rowling", 2003));
        listOfBooks.add(new Book("Harry Potter and the Half-Blood Prince", "J.K. Rowling", 2005));
        listOfBooks.add(new Book("Harry Potter and the Deathly Hollows", "J.K. Rowling", 2007));
    }

    public ArrayList<Book> getListOfBooks() {
        return listOfBooks;
    }

}
