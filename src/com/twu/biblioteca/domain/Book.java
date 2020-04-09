package com.twu.biblioteca.domain;

public class Book {

    private String name;
    private String author;
    private int publishYear;

    public Book(String name, String author, int publishYear) {
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return publishYear;
    }
}
