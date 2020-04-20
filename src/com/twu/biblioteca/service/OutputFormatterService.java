package com.twu.biblioteca.service;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Movie;
import com.twu.biblioteca.models.LibraryProduct;

public class OutputFormatterService {

    public void formatOutputProduct(LibraryProduct libraryProduct) {
        if (libraryProduct.getClass().getSimpleName().equals(Book.class.getSimpleName())) {
            formatOutputBook(libraryProduct);
        } else {
            formatOutputMovies(libraryProduct);
        }
    }

    public String formatOutputBook(LibraryProduct libraryProduct) {
        return String.format("%s, written by %s, published in %d\n", libraryProduct.getName(), libraryProduct.getAuthorOrDirector(), libraryProduct.getPublishedYear());
    }

    public String formatOutputMovies(LibraryProduct libraryProduct) {
        if (libraryProduct.getRate() == -1) {
            return String.format("%s, directed by %s, released in %d, unrated\n", libraryProduct.getName(), libraryProduct.getAuthorOrDirector(), libraryProduct.getPublishedYear());
        } else {
            return String.format("%s, directed by %s, released in %d, rating: %d\n", libraryProduct.getName(), libraryProduct.getAuthorOrDirector(), libraryProduct.getPublishedYear(), libraryProduct.getRate());
        }
    }
}
