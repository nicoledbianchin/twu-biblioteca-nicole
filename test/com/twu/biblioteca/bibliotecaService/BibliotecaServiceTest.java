package com.twu.biblioteca.bibliotecaService;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Library;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class BibliotecaServiceTest {

    Library library = new Library();

    @Test
    public void shouldReturnListOfBooks(){
    ArrayList<Book> list = library.getListOfBooks();

    ArrayList<Book> expectedList= new ArrayList();
    expectedList.add(new Book("Harry Potter and the Philosopher's Stone"));
    list.add(new Book("Harry Potter and the Chamber of Secrets"));
    list.add(new Book("Harry Potter and the Prisioner of Azkaban"));
    list.add(new Book("Harry Potter and the Glober of Fire"));
    list.add(new Book("Harry Potter and the Order of the Phoenix"));
    list.add(new Book("Harry Potter and the Half-Blood Prince"));
    list.add(new Book("Harry Potter and the Deathly Hollows"));

    for (int j = 0; j < expectedList.size(); j++){
        Assert.assertEquals(expectedList.get(j).getName(), list.get(j).getName());
    }
    }

}
