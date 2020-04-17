package com.twu.biblioteca.service;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Library;
import com.twu.biblioteca.domain.Movie;

import java.util.ArrayList;

public class LibraryService {
    private Library library = new Library();

    public ArrayList<Book> getListOfAvailableBooks() {
        return library.getListOfAvailableBooks();
    }

    public ArrayList<Book> getListOfLendedBooks() {
        return library.getListOfLendedBooks();
    }

    public void checkOutBook(int id) {
        Book newLendedBook = library.getListOfAvailableBooks().get(id);
        getListOfAvailableBooks().remove(id);

        addLendedBook(newLendedBook);
    }

    public void addLendedBook(Book book) {
        library.addLendedBook(book);
    }

    public void addAvailableBook(Book book) {
        library.addAvailableBook(book);
    }

    public Book getLendedBookByName(String name) {
        return library.getLendedBookByName(name);
    }

    public String returnBook(String name) {
        Book lendedBook = getLendedBookByName(name);
        if (lendedBook == null) {
            return "That is not a valid book to return";
        } else {
            getListOfLendedBooks().removeIf(book -> book.getName().equalsIgnoreCase(name));
            addAvailableBook(lendedBook);
            return "Thank you for returning the book.";
        }
    }

    public ArrayList<Movie> getListOfAvailableMovies() {
        return library.getListOfAvailableMovies();
    }
}
