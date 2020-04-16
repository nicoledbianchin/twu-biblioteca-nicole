package com.twu.biblioteca;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.service.MenuService;
import com.twu.biblioteca.service.OutputFormatterService;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        MenuService menuService = new MenuService();
        OutputFormatterService outputFormatterService = new OutputFormatterService();
        Scanner entry = new Scanner(System.in);

        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");

        System.out.println("1 - List of books");
        int userOption = entry.nextInt();


        switch (userOption) {
            case 1:
                System.out.println("\nSee our list of books available:");
                System.out.println("_________________________________");
                    for (Book book : menuService.getListOfBooks()) {
                        System.out.printf(outputFormatterService.formatOutputBooks(book));
                }
        }


        entry.close();
    }
}
