package com.twu.biblioteca.domain;

import java.util.ArrayList;

public class Library {

    ArrayList<Book> listOfBooks = new ArrayList();

    public Library() {
        listOfBooks.add(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 2000));
        listOfBooks.add(new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", 2000));
        listOfBooks.add(new Book("Harry Potter and the Prisioner of Azkaban", "J.K. Rowling", 2000));
        listOfBooks.add(new Book("Harry Potter and the Glober of Fire","J.K. Rowling", 2000));
        listOfBooks.add(new Book("Harry Potter and the Order of the Phoenix", "J.K. Rowling", 2000));
        listOfBooks.add(new Book("Harry Potter and the Half-Blood Prince", "J.K. Rowling", 2000));
        listOfBooks.add(new Book("Harry Potter and the Deathly Hollows", "J.K. Rowling", 2000));
    }

    public ArrayList<Book> getListOfBooks() {
        return listOfBooks;
    }
}
