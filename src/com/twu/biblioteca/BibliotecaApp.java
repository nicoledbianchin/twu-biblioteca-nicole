package com.twu.biblioteca;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Library;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        run(System.out);
    }

    public static void run(PrintStream printStream) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        ArrayList<Book> list = library.getListOfBooks();
        printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");

        printStream.printf("Menu:");
        printStream.printf("1 - List Books");
        int entry = scanner.nextInt();
        printStream.println(entry);

        printStream.println("\nSee our list of books available:");
        printStream.println("_________________________________");
        for (Book book : list) {
            printStream.println(book.getName() + "|" + book.getAuthor() + "|" + book.getYear());
        }
    }
}
