package com.twu.biblioteca.service;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Movie;

public class OutputFormatterService {

    public String formatOutputBooks(Book book) {
        return String.format( "%s, written by %s, published in %d\n", book.getName(), book.getAuthor(), book.getPublishedYear());
    }

    public String formatOutputMovies(Movie movie){
        if (movie.getRate() == -1) {
            return String.format("%s, directed by %s, released in %d\n", movie.getName(), movie.getDirector(), movie.getPublishedYear());
        } else {
            return String.format("%s, directed by %s, released in %d, rating: %d\n", movie.getName(), movie.getDirector(), movie.getPublishedYear(), movie.getRate());
        }
    }
}
