package com.twu.biblioteca;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Library;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library();
        ArrayList<Book> list = library.getListOfBooks();
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");

        System.out.println("\nSee our list of books available:");
        System.out.println("_________________________________");
        for (Book book : list) {
            System.out.println(book.getName());
        }

    }
}
