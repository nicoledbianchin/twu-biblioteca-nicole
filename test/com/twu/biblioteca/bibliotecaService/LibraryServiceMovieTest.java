package com.twu.biblioteca.bibliotecaService;

import com.twu.biblioteca.domain.Movie;
import org.junit.Before;

import java.util.ArrayList;

public class LibraryServiceMovieTest {

    private ArrayList<Movie> expectedList;

    @Before
    public void init() {
        expectedList = new ArrayList<Movie>();
        expectedList.add(new Movie("The Lord of the Rings: The Fellowship of the Ring", "Peter Jackson", 2002, 9));
        expectedList.add(new Movie("The Lord of the Rings: The Two Towers", "Peter Jackson", 2002, 10));
        expectedList.add(new Movie("The Lord of the Rings: The Return of the King", "Peter Jackson", 2003, 9));
        expectedList.add(new Movie("The Hobbit: An Unexpected Journey", "Peter Jackson", 2012, 9));
        expectedList.add(new Movie("The Hobbit: The Desolation of Smaug", "Peter Jackson", 2013, 9));
        expectedList.add(new Movie("The Hobbit: The Battle of the Five Armies", "Peter Jackson", 2014, 9));
    }
}
