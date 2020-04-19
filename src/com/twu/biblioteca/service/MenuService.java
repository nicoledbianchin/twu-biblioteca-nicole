package com.twu.biblioteca.service;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Movie;

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

    public void manipulateMenu(int userOption) {
        if (userOptions.containsKey(userOption)) {
            switch (userOption) {
                case 1:
                    System.out.println("\nSee our list of books available:");
                    System.out.println("_________________________________");
                    for (Book book : getListOfAvailableBooks()) {
                        System.out.print((getListOfAvailableBooks().indexOf(book) + 1) + " - ");
                        System.out.printf(outputFormatterService.formatOutputBooks(book));
                    }
                    break;

                case 2:
                    System.out.println("Inform the id of the book you want to check out: ");
                    int id = scanner.nextInt() - 1;
                    try {
                        libraryService.checkOutBook(id);
                        System.out.println("Thank you! Enjoy the book.");
                    } catch (Exception exception) {
                        System.out.println("Sorry, that book is not available.");
                    }
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.println("Inform the name of the book you want to return:");
                    String nameBook = scanner.nextLine();
                    String messageBook = libraryService.returnBook(nameBook);
                    System.out.println(messageBook);
                    break;
                case 4:
                    System.out.println("\nSee our list of movies available:");
                    System.out.println("_________________________________");
                    for (Movie movie : getListOfAvailableMovies()) {
                        System.out.print((getListOfAvailableMovies().indexOf(movie) + 1) + " - ");
                        System.out.printf(outputFormatterService.formatOutputMovies(movie));
                    }
                    break;
                case 5:
                    System.out.println("Inform the id of the movie you want to check out: ");
                    int idMovie = scanner.nextInt() - 1;
                    try {
                        libraryService.checkOutMovie(idMovie);
                        System.out.println("Thank you! Enjoy the movie.");
                    } catch (Exception exception) {
                        System.out.println("Sorry, that movie is not available.");
                    }
                    scanner.nextLine();
                    break;
                case 6:
                    System.out.println("Inform the name of the movie you want to return:");
                    String nameMovie = scanner.nextLine();
                    String messageMovie = libraryService.returnMovie(nameMovie);
                    System.out.println(messageMovie);
                    break;
            }

        } else {
            System.out.println("Please select a valid option!");
        }
    }

    public ArrayList<Book> getListOfAvailableBooks() {
        return libraryService.getListOfAvailableBooks();
    }

    public ArrayList<Movie> getListOfAvailableMovies() {
        return libraryService.getListOfAvailableMovies();
    }

}
