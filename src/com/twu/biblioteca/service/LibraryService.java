package com.twu.biblioteca.service;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Library;
import com.twu.biblioteca.domain.Movie;

import java.util.ArrayList;
import java.util.Map;

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

    private Book getLendedBookByName(String name) {
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

    public void checkOutMovie(int id) {
        Movie newLendedMovie = library.getListOfAvailableMovies().get(id);
        getListOfAvailableMovies().remove(id);

        addLendedMovie(newLendedMovie);
    }

    public void addLendedMovie(Movie movie) {
        library.addLendedMovie(movie);
    }

    public ArrayList<Movie> getListOfLendedMovies() {
        return library.getListOfLendedMovies();
    }

    private Movie getLendedMovieByName(String name) {
        return library.getLendedMovieByName(name);
    }

    public String returnMovie(String name) {
        Movie lendedMovie = getLendedMovieByName(name);
        if (lendedMovie == null) {
            return "That is not a valid movie to return";
        } else {
            getListOfLendedMovies().removeIf(book -> book.getName().equalsIgnoreCase(name));
            addAvailableMovie(lendedMovie);
            return "Thank you for returning the book.";
        }
    }

    private void addAvailableMovie(Movie lendedMovie) {
        library.addAvailableMovie(lendedMovie);
    }

}
