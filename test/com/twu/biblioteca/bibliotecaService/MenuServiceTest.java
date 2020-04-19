package com.twu.biblioteca.bibliotecaService;

import com.sun.org.apache.bcel.internal.generic.MONITORENTER;
import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Movie;
import com.twu.biblioteca.service.MenuService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class MenuServiceTest {

    private ArrayList<Book> expectedListBooks;
    private ArrayList<Movie> expectedListOfMovies;
    private MenuService menuService = new MenuService();


    @Before
    public void init() {
        expectedListBooks = new ArrayList();
        expectedListBooks.add(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997));
        expectedListBooks.add(new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", 1998));
        expectedListBooks.add(new Book("Harry Potter and the Prisioner of Azkaban", "J.K. Rowling", 1999));
        expectedListBooks.add(new Book("Harry Potter and the Globet of Fire", "J.K. Rowling", 2000));
        expectedListBooks.add(new Book("Harry Potter and the Order of the Phoenix", "J.K. Rowling", 2003));
        expectedListBooks.add(new Book("Harry Potter and the Half-Blood Prince", "J.K. Rowling", 2005));
        expectedListBooks.add(new Book("Harry Potter and the Deathly Hollows", "J.K. Rowling", 2007));

        expectedListOfMovies = new ArrayList();
        expectedListOfMovies.add(new Movie("The Lord of the Rings: The Fellowship of the Ring", "Peter Jackson", 2002, 9));
        expectedListOfMovies.add(new Movie("The Lord of the Rings: The Two Towers", "Peter Jackson", 2002, 10));
        expectedListOfMovies.add(new Movie("The Lord of the Rings: The Return of the King", "Peter Jackson", 2003, 9));
        expectedListOfMovies.add(new Movie("The Hobbit: An Unexpected Journey", "Peter Jackson", 2012));
        expectedListOfMovies.add(new Movie("The Hobbit: The Desolation of Smaug", "Peter Jackson", 2013));
        expectedListOfMovies.add(new Movie("The Hobbit: The Battle of the Five Armies", "Peter Jackson", 2014));
    }

    @Test
    public void shouldReturnListOfBooks() {
        ArrayList<Book> list = menuService.getListOfAvailableBooks();
        for (int j = 0; j < expectedListBooks.size(); j++) {
            Assert.assertEquals(expectedListBooks.get(j).getName(), list.get(j).getName());
            Assert.assertEquals(expectedListBooks.get(j).getAuthor(), list.get(j).getAuthor());
            Assert.assertEquals(expectedListBooks.get(j).getPublishedYear(), list.get(j).getPublishedYear());
        }
    }

    @Test
    public void shouldReturnListOfMovies() {
        ArrayList<Movie> list = menuService.getListOfAvailableMovies();
        for (int j = 0; j < expectedListOfMovies.size(); j++) {
            Assert.assertEquals(expectedListOfMovies.get(j).getName(), list.get(j).getName());
            Assert.assertEquals(expectedListOfMovies.get(j).getDirector(), list.get(j).getDirector());
            Assert.assertEquals(expectedListOfMovies.get(j).getPublishedYear(), list.get(j).getPublishedYear());
            Assert.assertEquals(expectedListOfMovies.get(j).getRate(), list.get(j).getRate());
        }
    }
}
