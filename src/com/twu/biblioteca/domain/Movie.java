package com.twu.biblioteca.domain;

import com.twu.biblioteca.models.LibraryProduct;

public class Movie implements LibraryProduct {

    private String name;
    private String director;
    private int publishedYear;
    private int rate;

    public Movie(String name, String director, int publishedYear, int rate) {
        this.name = name;
        this.director = director;
        this.publishedYear = publishedYear;
        this.rate = rate;
    }

    public Movie(String name, String director, int publishedYear) {
        this.name = name;
        this.director = director;
        this.publishedYear = publishedYear;
        this.rate = -1;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAuthorOrDirector() {
        return director;
    }

    @Override
    public int getPublishedYear() {
        return publishedYear;
    }

    @Override
    public int getRate() {
        return rate;
    }
}
