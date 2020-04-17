package com.twu.biblioteca.domain;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> listOfAvailableBooks = new ArrayList();
    private ArrayList<Book> listOfLendedBooks = new ArrayList<>();

    public Library() {
        listOfAvailableBooks.add(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997));
        listOfAvailableBooks.add(new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", 1998));
        listOfAvailableBooks.add(new Book("Harry Potter and the Prisioner of Azkaban", "J.K. Rowling", 1999));
        listOfAvailableBooks.add(new Book("Harry Potter and the Globet of Fire", "J.K. Rowling", 2000));
        listOfAvailableBooks.add(new Book("Harry Potter and the Order of the Phoenix", "J.K. Rowling", 2003));
        listOfAvailableBooks.add(new Book("Harry Potter and the Half-Blood Prince", "J.K. Rowling", 2005));
        listOfAvailableBooks.add(new Book("Harry Potter and the Deathly Hollows", "J.K. Rowling", 2007));
    }

    public ArrayList<Book> getListOfAvailableBooks() {
        return listOfAvailableBooks;
    }

    public ArrayList<Book> getListOfLendedBooks() {
        return listOfLendedBooks;
    }

    public void addLendedBook(Book book) {
        listOfLendedBooks.add(book);
    }

    public void addAvailableBook(Book book) {
        listOfAvailableBooks.add(book);
    }

    public Book getLendedBookByName(String name) {
        Book lendedBook = null;
        for (Book book : listOfLendedBooks) {
            if (book.getName().equalsIgnoreCase(name)) {
                lendedBook = book;
            }
        }
        return lendedBook;
    }
}
