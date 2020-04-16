package com.twu.biblioteca.bibliotecaService;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.service.LibraryService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class LibraryServiceTest {

    private ArrayList<Book> expectedList;
    LibraryService libraryService = new LibraryService();
    ArrayList<Book> list = libraryService.getListOfBooks();

    @Before
    public void init() {
        expectedList = new ArrayList();
        expectedList.add(new Book("Harry Potter and the Philosopher's Stone"));
        list.add(new Book("Harry Potter and the Chamber of Secrets"));
        list.add(new Book("Harry Potter and the Prisioner of Azkaban"));
        list.add(new Book("Harry Potter and the Glober of Fire"));
        list.add(new Book("Harry Potter and the Order of the Phoenix"));
        list.add(new Book("Harry Potter and the Half-Blood Prince"));
        list.add(new Book("Harry Potter and the Deathly Hollows"));
    }

    @Test
    public void shouldReturnListOfBooks() {
        for (int j = 0; j < expectedList.size(); j++) {
            Assert.assertEquals(expectedList.get(j).getName(), list.get(j).getName());
        }
    }

}
