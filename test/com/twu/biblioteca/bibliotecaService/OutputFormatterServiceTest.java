package com.twu.biblioteca.bibliotecaService;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Movie;
import com.twu.biblioteca.service.OutputFormatterService;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class OutputFormatterServiceTest {

    private OutputFormatterService outputFormatterService = new OutputFormatterService();

    @Test
    public void shouldReturnStringFormattedWithBookInformations() {
        Book book = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997);

        String actualString = outputFormatterService.formatOutputBook(book);
        String expectedString = "Harry Potter and the Philosopher's Stone, written by J.K. Rowling, published in 1997\n";

        Assert.assertThat(actualString, is(equalTo(expectedString)));
    }

    @Test
    public void shouldReturnStringFormattedWithRate() {
        Movie movie = new Movie("The Lord of the Rings: The Fellowship of the Ring", "Peter Jackson", 2002, 9);

        String actualString = outputFormatterService.formatOutputMovies(movie);
        String expectedString = "The Lord of the Rings: The Fellowship of the Ring, directed by Peter Jackson, released in 2002, rating: 9\n";

        Assert.assertThat(actualString, is(equalTo(expectedString)));
    }

        @Test
    public void shouldReturnStringFormattedWithoutRate() {
        Movie movie = new Movie("The Hobbit: The Battle of the Five Armies", "Peter Jackson", 2014);

        String actualString = outputFormatterService.formatOutputMovies(movie);
        String expectedString = "The Hobbit: The Battle of the Five Armies, directed by Peter Jackson, released in 2014, unrated\n";

        Assert.assertThat(actualString, is(equalTo(expectedString)));
    }
}
