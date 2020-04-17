package com.twu.biblioteca.bibliotecaService;

import com.twu.biblioteca.domain.Movie;
import com.twu.biblioteca.service.LibraryService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;

public class LibraryServiceMovieTest {

    private ArrayList<Movie> expectedList;
    private LibraryService libraryService = new LibraryService();
    private ArrayList<Movie> list = libraryService.getListOfAvailableMovies();

    @Before
    public void init() {
        expectedList = new ArrayList();
        expectedList.add(new Movie("The Lord of the Rings: The Fellowship of the Ring", "Peter Jackson", 2002, 9));
        expectedList.add(new Movie("The Lord of the Rings: The Two Towers", "Peter Jackson", 2002, 10));
        expectedList.add(new Movie("The Lord of the Rings: The Return of the King", "Peter Jackson", 2003, 9));
        expectedList.add(new Movie("The Hobbit: An Unexpected Journey", "Peter Jackson", 2012, 9));
        expectedList.add(new Movie("The Hobbit: The Desolation of Smaug", "Peter Jackson", 2013, 9));
        expectedList.add(new Movie("The Hobbit: The Battle of the Five Armies", "Peter Jackson", 2014, 9));
    }

    @Test
    public void shouldReturnListOfMovies() {
        for (int i = 0; i < expectedList.size(); i++) {
            Assert.assertThat(list.get(i).getName(), is(equals(expectedList.get(i).getName())));
        }
    }
}
