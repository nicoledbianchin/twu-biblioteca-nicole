package com.twu.biblioteca.bibliotecaService;

import com.twu.biblioteca.domain.objects.Book;
import com.twu.biblioteca.domain.objects.Movie;
import com.twu.biblioteca.domain.objects.User;
import com.twu.biblioteca.models.LibraryProduct;
import com.twu.biblioteca.service.LibraryService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;

public class LibraryServiceTest {

    private ArrayList<LibraryProduct> expectedList;
    private LibraryService libraryService = new LibraryService();
    private ArrayList<LibraryProduct> actualList = libraryService.getListOfAvailableProducts();

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
    public void shouldReturnFirtItemOnTheList() {
        for (int j = 0; j < expectedList.size(); j++) {
            Assert.assertEquals(expectedList.get(j).getName(), actualList.get(j).getName());
        }
    }

    @Test
    public void shouldDecreaseListSizeByOne() {
        int expectedSize = actualList.size() - 1;
        libraryService.checkOutProduct("Harry Potter and the Philosopher's Stone", null);

        Assert.assertThat(actualList.size(), is(expectedSize));
    }

    @Test
    public void shouldRemoveProductFromList() {
        libraryService.checkOutProduct("Harry Potter and the Philosopher's Stone", null);

        Assert.assertThat(actualList.get(0).getName(), is(not(equalTo("Harry Potter and the Philosopher's Stone"))));
    }

    @Test
    public void shouldPopulateListOfLandedProducts() {
        Book book = new Book("Eu, Robô", "Isaac Asimov", 1950);

        libraryService.addLendedProduct(book);

        Assert.assertThat(libraryService.getListOfLendedProducts().get(0), is(equalTo(book)));
    }

    @Test
    public void shouldRemoveBookFromAvailableListAndAddInLandedList() {
        LibraryProduct libraryProduct = actualList.get(0);
        libraryService.checkOutProduct( "Harry Potter and the Philosopher's Stone", null);

        Assert.assertFalse(actualList.contains(libraryProduct));
        Assert.assertTrue(libraryService.getListOfLendedProducts().contains(libraryProduct));
    }

    @Test
    public void shouldRemoveBookFromListOfLendedProducts() {
        Book book = new Book("Eu, Robô", "Isaac Asimov", 1950);
        libraryService.addLendedProduct(book);

        libraryService.returnProduct("Eu, Robô");

        Assert.assertTrue(libraryService.getListOfLendedProducts().isEmpty());
    }

    @Test
    public void shouldRemoveBookFromListOfLendedAndAddInListOfAvailable() {
        Book book = new Book("Eu, Robô", "Isaac Asimov", 1950);
        libraryService.addLendedProduct(book);

        libraryService.returnProduct("Eu, Robô");

        Assert.assertTrue(libraryService.getListOfLendedProducts().isEmpty());
        Assert.assertTrue(libraryService.getListOfAvailableProducts().contains(book));
    }

    @Test
    public void shouldReturnTrueToCheckoutValidProduct() {
        Book book = new Book("Eu, Robô", "Isaac Asimov", 1950);
        libraryService.addAvailableProduct(book);

        boolean valid = libraryService.checkOutProduct("Eu, Robô", null);

        Assert.assertTrue(valid);
    }

    @Test
    public void shouldReturnFalseToCheckoutInvalidProduct() {
        boolean valid = libraryService.checkOutProduct("Eu, Robô", null);

        Assert.assertFalse(valid);
    }

    @Test
    public void shouldReturnTrueToValidBook() {
        Book book = new Book("Eu, Robô", "Isaac Asimov", 1950);
        libraryService.addLendedProduct(book);

        boolean valid = libraryService.returnProduct("Eu, Robô");

        Assert.assertTrue(valid);
    }

    @Test
    public void shouldReturnTrueToValidMovie() {
        Movie movie = new Movie("Matilda", "Danny DeVito", 1996);
        libraryService.addLendedProduct(movie);

        boolean valid = libraryService.returnProduct("Matilda");

        Assert.assertTrue(valid);
    }

    @Test
    public void shouldReturnFalseToUnvalidBook() {
        Book book = new Book("Eu, Robô", "Isaac Asimov", 1950);
        libraryService.addAvailableProduct(book);

        boolean valid = libraryService.returnProduct("Other Name");

        Assert.assertFalse(valid);
    }

    @Test
    public void shouldReturnUserWhoCheckedOutTheBook() {
        libraryService.checkOutProduct("Harry Potter and the Philosopher's Stone", "Nicole");

        String actualName = libraryService.getUserCheckoutItem("Harry Potter and the Philosopher's Stone");

        Assert.assertThat(actualName, is(equalTo("Nicole")));
    }

    @Test
    public void shouldReturnCheckOutInformation() {
        libraryService.checkOutProduct("Harry Potter and the Philosopher's Stone", "Trixie");
        String actualString = libraryService.getCheckoutInformation();

        String expectedString = "Book: Harry Potter and the Philosopher's Stone, name: Trixie\n";

        Assert.assertThat(actualString, is(equalTo(expectedString)));
    }

}
