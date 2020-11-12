package com.twu.biblioteca.bibliotecaService;

import com.twu.biblioteca.domain.objects.Book;
import com.twu.biblioteca.domain.objects.Movie;
import com.twu.biblioteca.models.LibraryProduct;
import com.twu.biblioteca.service.MenuService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class MenuServiceTest {

    private ArrayList<LibraryProduct> expectedList;
    private MenuService menuService = new MenuService();


    @Before
    public void init() {
        expectedList = new ArrayList();
        expectedList.add(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997));
        expectedList.add(new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", 1998));
        expectedList.add(new Book("Harry Potter and the Prisioner of Azkaban", "J.K. Rowling", 1999));
        expectedList.add(new Book("Harry Potter and the Globet of Fire", "J.K. Rowling", 2000));
        expectedList.add(new Book("Harry Potter and the Order of the Phoenix", "J.K. Rowling", 2003));
        expectedList.add(new Book("Harry Potter and the Half-Blood Prince", "J.K. Rowling", 2005));
        expectedList.add(new Book("Harry Potter and the Deathly Hollows", "J.K. Rowling", 2007));

        expectedList.add(new Movie("The Lord of the Rings: The Fellowship of the Ring", "Peter Jackson", 2002, 9));
        expectedList.add(new Movie("The Lord of the Rings: The Two Towers", "Peter Jackson", 2002, 10));
        expectedList.add(new Movie("The Lord of the Rings: The Return of the King", "Peter Jackson", 2003, 9));
        expectedList.add(new Movie("The Hobbit: An Unexpected Journey", "Peter Jackson", 2012));
        expectedList.add(new Movie("The Hobbit: The Desolation of Smaug", "Peter Jackson", 2013));
        expectedList.add(new Movie("The Hobbit: The Battle of the Five Armies", "Peter Jackson", 2014));
    }

    @Test
    public void shouldReturnFirstItemOfTheList() {
        ArrayList<LibraryProduct> list = menuService.getListOfAvailableProduts();
        for (int j = 0; j < expectedList.size(); j++) {
            Assert.assertEquals(expectedList.get(j).getName(), list.get(j).getName());
            Assert.assertEquals(expectedList.get(j).getAuthorOrDirector(), list.get(j).getAuthorOrDirector());
            Assert.assertEquals(expectedList.get(j).getPublishedYear(), list.get(j).getPublishedYear());
        }
    }

    @Test
    public void shouldReturnFirstItemOfListOfMovies() {
        ArrayList<LibraryProduct> list = menuService.getListOfAvailableProduts();
        for (int j = 0; j < expectedList.size(); j++) {
            Assert.assertEquals(expectedList.get(j).getName(), list.get(j).getName());
            Assert.assertEquals(expectedList.get(j).getAuthorOrDirector(), list.get(j).getAuthorOrDirector());
            Assert.assertEquals(expectedList.get(j).getPublishedYear(), list.get(j).getPublishedYear());
            Assert.assertEquals(expectedList.get(j).getRate(), list.get(j).getRate());
        }
    }
}
