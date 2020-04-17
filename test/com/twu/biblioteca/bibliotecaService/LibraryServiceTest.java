package com.twu.biblioteca.bibliotecaService;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.service.LibraryService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;

public class LibraryServiceTest {

    private ArrayList<Book> expectedList;
    private LibraryService libraryService = new LibraryService();
    private ArrayList<Book> list = libraryService.getListOfAvailableBooks();

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
    }

    @Test
    public void shouldReturnListOfBooks() {
        for (int j = 0; j < expectedList.size(); j++) {
            Assert.assertEquals(expectedList.get(j).getName(), list.get(j).getName());
        }
    }

    @Test
    public void souldHaveAuthorPerBook() {
        for (int i = 0; i < list.size(); i++) {
            Assert.assertThat(list.get(i).getAuthor(), is(not(equalTo(null))));
        }
    }

    @Test
    public void shouldHavePublishedYearPerBook() {
        for (int i = 0; i < list.size(); i++) {
            Assert.assertThat(list.get(i).getPublishedYear(), is(not(equalTo(null))));
        }
    }

    @Test
    public void shouldDecreaseListSizeByOne() {
        int expectedSize = list.size() - 1;
        libraryService.checkOutBook(0);

        Assert.assertThat(list.size(), is(expectedSize));
    }

    @Test
    public void shouldRemoveBookFromList() {
        String expectedName = list.get(1).getName();
        libraryService.checkOutBook(0);

        Assert.assertThat(list.get(0).getName(), is(equalTo(expectedName)));
    }

    @Test
    public void shouldPopulateListOfLandedBooks() {
        Book book = new Book("Eu, Robô", "Isaac Asimov", 1950);

        libraryService.addLendedBook(book);

        Assert.assertThat(libraryService.getListOfLendedBooks().get(0), is(equalTo(book)));
    }

    @Test
    public void shouldRemoveBookFromAvailableListAndAddInLandedList() {
        Book book = list.get(0);
        libraryService.checkOutBook(0);

        Assert.assertThat(list.get(0), is(not(equalTo(book))));
        Assert.assertThat(libraryService.getListOfLendedBooks().get(0), is(equalTo(book)));
    }

    @Test
    public void shouldRemoveBookFromListOfLendedBooks() {
        Book book = new Book("Eu, Robô", "Isaac Asimov", 1950);
        libraryService.addLendedBook(book);

        libraryService.returnBook("Eu, Robô");

        Assert.assertTrue(libraryService.getListOfLendedBooks().isEmpty());
    }

    @Test
    public void shouldRemoveBookFromListOfLendedBooksAndAddInListOfAvailableBooks() {
        Book book = new Book("Eu, Robô", "Isaac Asimov", 1950);
        libraryService.addLendedBook(book);

        libraryService.returnBook("Eu, Robô");

        Assert.assertTrue(libraryService.getListOfLendedBooks().isEmpty());
        Assert.assertTrue(libraryService.getListOfAvailableBooks().contains(book));
    }

    @Test
    public void shouldReturnSuccessflMessageToReturnValidBook() {
        Book book = new Book("Eu, Robô", "Isaac Asimov", 1950);
        libraryService.addLendedBook(book);

        String message = libraryService.returnBook("Eu, Robô");

        Assert.assertThat(message, is(equalTo("Thank you for returning the book.")));
    }

    @Test
    public void shouldReturnUnsuccessfulMessageToReturnUnvalidBook() {
        Book book = new Book("Eu, Robô", "Isaac Asimov", 1950);
        libraryService.addAvailableBook(book);

        String message = libraryService.returnBook("Other Name");

        Assert.assertThat(message, is(equalTo("That is not a valid book to return")));
    }

}
