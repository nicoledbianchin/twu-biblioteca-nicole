package com.twu.biblioteca.domain;

public class Movie {

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
    }

    public String getName() {
        return name;
    }
}
