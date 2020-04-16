package com.twu.biblioteca.service;

import com.twu.biblioteca.domain.Book;

public class OutputFormatterService {

    public String formatOutputBooks(Book book) {
        return String.format( "%s, %s, %d\n", book.getName(), book.getAuthor(), book.getPublishedYear());
    }
}
