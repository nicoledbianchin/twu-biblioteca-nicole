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
    LibraryService libraryService = new LibraryService();
    ArrayList<Book> list = libraryService.getListOfBooks();

    @Before
    public void init() {
        expectedList = new ArrayList();
        expectedList.add(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling"));
        list.add(new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling"));
        list.add(new Book("Harry Potter and the Prisioner of Azkaban", "J.K. Rowling"));
        list.add(new Book("Harry Potter and the Globet of Fire", "J.K. Rowling"));
        list.add(new Book("Harry Potter and the Order of the Phoenix", "J.K. Rowling"));
        list.add(new Book("Harry Potter and the Half-Blood Prince", "J.K. Rowling"));
        list.add(new Book("Harry Potter and the Deathly Hollows", "J.K. Rowling"));
    }

    @Test
    public void shouldReturnListOfBooks() {
        for (int j = 0; j < expectedList.size(); j++) {
            Assert.assertEquals(expectedList.get(j).getName(), list.get(j).getName());
        }
    }

    @Test
    public void souldHaveAnAuthorPerBook() {
        for (int i = 0; i < expectedList.size(); i++) {
            Assert.assertThat(expectedList.get(i).getAuthor(), is(not(equalTo(null))));
        }
    }

}
