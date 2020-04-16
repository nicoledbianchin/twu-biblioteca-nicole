package com.twu.biblioteca.service;

import com.twu.biblioteca.domain.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MenuService {
    private LibraryService libraryService = new LibraryService();
    OutputFormatterService outputFormatterService = new OutputFormatterService();
    private Map<Integer, String> userOptions = new HashMap<>();
    private boolean optionIsValid = false;

    public MenuService() {
        userOptions.put(1, "1 - List of books");
    }

    public void showMenu() {
        System.out.println(userOptions.get(1));
    }


    public void manipulateMenu(int userOption) {
        if (userOptions.containsKey(userOption)) {
            switch (userOption) {
                case 1:
                    System.out.println("\nSee our list of books available:");
                    System.out.println("_________________________________");
                    for (Book book : getListOfBooks()) {
                        System.out.printf(outputFormatterService.formatOutputBooks(book));
                    }
            }
        } else {
            System.out.println("Please select a valid option!");
        }
    }

    public ArrayList<Book> getListOfBooks() {
        return libraryService.getListOfBooks();
    }
}
