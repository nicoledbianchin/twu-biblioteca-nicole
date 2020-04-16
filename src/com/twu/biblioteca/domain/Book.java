package com.twu.biblioteca.domain;

public class Book {

    private String author;
    private String name;
    private int publishedYear;

    public Book(String name, String author, int publishedYear) {
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }
}
