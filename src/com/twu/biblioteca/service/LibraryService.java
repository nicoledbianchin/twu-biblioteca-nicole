package com.twu.biblioteca.service;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Library;

import java.util.ArrayList;

public class LibraryService {
    private Library library = new Library();

    public ArrayList<Book> getListOfAvailableBooks() {
        return library.getListOfAvailableBooks();
    }

    public ArrayList<Book> getListOfLendedBooks() {
        return library.getListOfLendedBooks();
    }

    public void checkOutBook(int id) {
        Book newLendedBook = library.getListOfAvailableBooks().get(id);
        getListOfAvailableBooks().remove(id);

        addLendedBook(newLendedBook);
    }

    public void addLendedBook(Book book){
           library.addLendedBook(book);
    }
}
