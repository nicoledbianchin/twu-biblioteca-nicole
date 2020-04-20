package com.twu.biblioteca.service;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Movie;
import com.twu.biblioteca.models.LibraryProduct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuService {
    private LibraryService libraryService = new LibraryService();
    private OutputFormatterService outputFormatterService = new OutputFormatterService();
    private Map<Integer, String> userOptions = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public MenuService() {
        userOptions.put(1, "1 - List of books");
        userOptions.put(2, "2 - Check out book");
        userOptions.put(3, "3 - Return book");
        userOptions.put(4, "4 - Show list of available movies");
        userOptions.put(5, "5 - Check out movie");
        userOptions.put(6, "6 - Return Movie");
        userOptions.put(7, "7 - Exit");
    }

    public void showMenu() {
        System.out.println("Menu: ");
        for (String option : userOptions.values()) {
            System.out.println(option);
        }
    }

    private ArrayList<LibraryProduct> getListOfAvailableProduts() {
        return libraryService.getListOfAvailableProducts();
    }

    public void manipulateMenu(int userOption) {
        if (userOptions.containsKey(userOption)) {
            switch (userOption) {

                case 1:
                    System.out.println("\nSee our list of books available:");
                    System.out.println("_________________________________");
                    for (LibraryProduct libraryProduct : getListOfAvailableProduts()) {
                        if (libraryProduct.getClass().getSimpleName().equals(Book.class.getSimpleName())){
                        System.out.printf(outputFormatterService.formatOutputBook(libraryProduct));
                        }
                    }
                    break;

                case 2:
                    System.out.println("Inform the name of the book you want to check out: ");
                    String name = scanner.nextLine();
                    try {
                        libraryService.checkOutProduct(name);
                        System.out.println("Thank you! Enjoy the book.");
                    } catch (Exception exception) {
                        System.out.println("Sorry, that book is not available.");
                    }
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.println("Inform the name of the book you want to return:");
                    String nameBook = scanner.nextLine();
                    String messageBook = libraryService.returnProduct(nameBook);
                    System.out.println(messageBook);
                    break;
                case 4:
                    System.out.println("\nSee our list of movies available:");
                    System.out.println("_________________________________");
                    for (LibraryProduct libraryProduct : getListOfAvailableProduts()) {
                        if (libraryProduct.getClass().getSimpleName().equals(Movie.class.getSimpleName()))
                        System.out.printf(outputFormatterService.formatOutputMovies(libraryProduct));
                    }
                    break;
                case 5:
                    System.out.println("Inform the name of the movie you want to check out: ");
                    String nameMovie = scanner.nextLine();
                    try {
                        libraryService.checkOutProduct(nameMovie);
                        System.out.println("Thank you! Enjoy the movie.");
                    } catch (Exception exception) {
                        System.out.println("Sorry, that movie is not available.");
                    }
                    scanner.nextLine();
                    break;
                case 6:
                    System.out.println("Inform the name of the movie you want to return:");
                    String nameMovieReturn = scanner.nextLine();
                    String messageMovie = libraryService.returnProduct(nameMovieReturn);
                    System.out.println(messageMovie);
                    break;
            }
        } else {
            System.out.println("Please select a valid option!");
        }

    }
}
