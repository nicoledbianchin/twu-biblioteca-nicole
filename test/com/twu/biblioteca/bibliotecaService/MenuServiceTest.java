package com.twu.biblioteca.bibliotecaService;

import com.twu.biblioteca.domain.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class MenuServiceTest {

    private ArrayList<Book> expectedList;
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
    }

    @Test
    public void shouldReturnListOfBooks() {
        ArrayList<Book> list = menuService.getListOfBooks();
        for (int j = 0; j < expectedList.size(); j++) {
            Assert.assertEquals(expectedList.get(j).getName(), list.get(j).getName());
        }

    }
}
