package com.twu.biblioteca.domain;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void getName() {
    }

    @Test
    public void shouldGetBooksAuthor() {
        Book book = new Book("Percy Jackson", "Rick Riordan", 2011);

        String author = book.getAuthor();
        String expectedAuthor = "Rick Riordan";

        Assert.assertThat(author, is(equalTo(expectedAuthor)));
    }

    @Test
    public void shouldGetBooksPublishYear() {
        Book book = new Book("Percy Jackson", "Rick Riordan", 2011);

        int year = book.getYear();
        int expectedYear = 2011;

        Assert.assertThat(year, is(equalTo(expectedYear)));
    }
}