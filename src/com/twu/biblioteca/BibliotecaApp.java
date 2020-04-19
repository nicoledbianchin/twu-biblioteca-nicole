package com.twu.biblioteca;

import com.twu.biblioteca.service.MenuService;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        MenuService menuService = new MenuService();
        Scanner entry = new Scanner(System.in);
        int userOption;

        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        do {
            menuService.showMenu();
            userOption = entry.nextInt();

            menuService.manipulateMenu(userOption);
            System.out.println("");

        } while (userOption != 5);

        System.out.printf("Thank you for using Biblioteca!");

        entry.close();
    }
}
