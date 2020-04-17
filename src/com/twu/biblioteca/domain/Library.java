package com.twu.biblioteca.domain;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> listOfAvailableBooks = new ArrayList();
    private ArrayList<Book> listOfLendedBooks = new ArrayList<>();
    private ArrayList<Movie> listOfAvailableMovies = new ArrayList<>();

    public Library() {
        listOfAvailableBooks.add(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997));
        listOfAvailableBooks.add(new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", 1998));
        listOfAvailableBooks.add(new Book("Harry Potter and the Prisioner of Azkaban", "J.K. Rowling", 1999));
        listOfAvailableBooks.add(new Book("Harry Potter and the Globet of Fire", "J.K. Rowling", 2000));
        listOfAvailableBooks.add(new Book("Harry Potter and the Order of the Phoenix", "J.K. Rowling", 2003));
        listOfAvailableBooks.add(new Book("Harry Potter and the Half-Blood Prince", "J.K. Rowling", 2005));
        listOfAvailableBooks.add(new Book("Harry Potter and the Deathly Hollows", "J.K. Rowling", 2007));

        listOfAvailableMovies.add(new Movie("The Lord of the Rings: The Fellowship of the Ring", "Peter Jackson", 2002, 9));
        listOfAvailableMovies.add(new Movie("The Lord of the Rings: The Two Towers", "Peter Jackson", 2002, 10));
        listOfAvailableMovies.add(new Movie("The Lord of the Rings: The Return of the King", "Peter Jackson", 2003, 9));
        listOfAvailableMovies.add(new Movie("The Hobbit: An Unexpected Journey", "Peter Jackson", 2012, 9));
        listOfAvailableMovies.add(new Movie("The Hobbit: The Desolation of Smaug", "Peter Jackson", 2013, 9));
        listOfAvailableMovies.add(new Movie("The Hobbit: The Battle of the Five Armies", "Peter Jackson", 2014, 9));
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

    public ArrayList<Movie> getListOfAvailableMovies() {
        return listOfAvailableMovies;
    }
}
