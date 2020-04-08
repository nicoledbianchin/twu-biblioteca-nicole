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

    for (int j = 0; j < expectedList.size(); j++){
        Assert.assertEquals(expectedList.get(j).getName(), list.get(j).getName());
    }
    }

}
