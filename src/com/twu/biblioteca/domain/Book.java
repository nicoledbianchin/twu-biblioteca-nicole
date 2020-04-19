package com.twu.biblioteca.domain;

import com.twu.biblioteca.models.LibraryProduct;

public class Book implements LibraryProduct {

    private String author;
    private String name;
    private int publishedYear;

    public Book(String name, String author, int publishedYear) {
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public int getPublishedYear() {
        return publishedYear;
    }
}
