package com.twu.biblioteca;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Library;
import com.twu.biblioteca.service.LibraryService;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService();
        ArrayList<Book> list = libraryService.getListOfBooks();
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");

        System.out.println("\nSee our list of books available:");
        System.out.println("_________________________________");
        for (Book book : list) {
            System.out.println(libraryService.toString(book));
        }

    }
}
