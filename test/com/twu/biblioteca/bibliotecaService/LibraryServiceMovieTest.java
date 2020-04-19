package com.twu.biblioteca.bibliotecaService;

import com.twu.biblioteca.domain.Movie;
import com.twu.biblioteca.service.LibraryService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.*;

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
        expectedList.add(new Movie("The Hobbit: An Unexpected Journey", "Peter Jackson", 2012));
        expectedList.add(new Movie("The Hobbit: The Desolation of Smaug", "Peter Jackson", 2013));
        expectedList.add(new Movie("The Hobbit: The Battle of the Five Armies", "Peter Jackson", 2014));
    }

    @Test
    public void shouldReturnListOfMovies() {
        for (int i = 0; i < expectedList.size(); i++) {
            Assert.assertEquals(list.get(i).getName(), expectedList.get(i).getName());
        }
    }

    @Test
    public void shouldHaveDirectorPerBook() {
        for (int i = 0; i < expectedList.size(); i++) {
            Assert.assertEquals(list.get(i).getDirector(), expectedList.get(i).getDirector());
        }
    }

    @Test
    public void shouldHavePublishedYearPerBook() {
        for (int i = 0; i < expectedList.size(); i++) {
            Assert.assertEquals(list.get(i).getPublishedYear(), expectedList.get(i).getPublishedYear());
        }
    }

    @Test
    public void shouldReturnRate() {
        for (int i = 0; i < expectedList.size(); i++) {
            Assert.assertEquals(list.get(i).getRate(), expectedList.get(i).getRate());
        }
    }

    @Test
    public void shouldAddLendedMovieToTheList() {
        Movie movie = new Movie("Matilda", "Danny DeVito", 1996);

        libraryService.addLendedMovie(movie);

        Assert.assertThat(libraryService.getListOfLendedMovies().get(0), is(equalTo(movie)));
    }

    @Test
    public void shouldDecreaseListSizeByOne() {
        int expectedSize = list.size() - 1;
        libraryService.checkOutMovie(0);

        Assert.assertThat(list.size(), is(expectedSize));
    }

    @Test
    public void shouldRemoveMovieFromAvailableList() {
        libraryService.checkOutMovie(0);

        Assert.assertFalse(libraryService.getListOfAvailableBooks().contains(list.get(0)));
    }

    @Test
    public void shouldRemoveMovieFromAvailableAndAddToLended() {
        Movie movie = list.get(0);

        libraryService.checkOutMovie(0);

        Assert.assertFalse(list.contains(movie));
        Assert.assertTrue(libraryService.getListOfLendedMovies().contains(movie));
    }

    @Test
    public void shouldRemoveBookFromLendedList() {
        Movie movie = new Movie("Matilda", "Danny DeVito", 1996);
        libraryService.addLendedMovie(movie);

        libraryService.returnMovie("Matilda");

        Assert.assertFalse(libraryService.getListOfLendedMovies().contains(movie));
    }

}
