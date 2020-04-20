package com.twu.biblioteca.domain.objectsCuration;

import com.twu.biblioteca.domain.objects.Book;
import com.twu.biblioteca.domain.objects.Movie;
import com.twu.biblioteca.domain.objects.User;
import com.twu.biblioteca.models.LibraryProduct;

import java.util.ArrayList;

public class Library {

    
    private final ArrayList<LibraryProduct> listOfAvailableProducts = new ArrayList<>();
    private final ArrayList<LibraryProduct> listOfLendedProducts = new ArrayList<>();
    private final ArrayList<User> listOfUsers = new ArrayList<>();
    

    public Library() {
        listOfAvailableProducts.add(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997));
        listOfAvailableProducts.add(new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", 1998));
        listOfAvailableProducts.add(new Book("Harry Potter and the Prisioner of Azkaban", "J.K. Rowling", 1999));
        listOfAvailableProducts.add(new Book("Harry Potter and the Globet of Fire", "J.K. Rowling", 2000));
        listOfAvailableProducts.add(new Book("Harry Potter and the Order of the Phoenix", "J.K. Rowling", 2003));
        listOfAvailableProducts.add(new Book("Harry Potter and the Half-Blood Prince", "J.K. Rowling", 2005));
        listOfAvailableProducts.add(new Book("Harry Potter and the Deathly Hollows", "J.K. Rowling", 2007));

        listOfAvailableProducts.add(new Movie("The Lord of the Rings: The Fellowship of the Ring", "Peter Jackson", 2002, 9));
        listOfAvailableProducts.add(new Movie("The Lord of the Rings: The Two Towers", "Peter Jackson", 2002, 10));
        listOfAvailableProducts.add(new Movie("The Lord of the Rings: The Return of the King", "Peter Jackson", 2003, 9));
        listOfAvailableProducts.add(new Movie("The Hobbit: An Unexpected Journey", "Peter Jackson", 2012));
        listOfAvailableProducts.add(new Movie("The Hobbit: The Desolation of Smaug", "Peter Jackson", 2013));
        listOfAvailableProducts.add(new Movie("The Hobbit: The Battle of the Five Armies", "Peter Jackson", 2014));
    }

    public ArrayList<LibraryProduct> getListOfAvailableProducts() {
        return listOfAvailableProducts;
    }

    public ArrayList<LibraryProduct> getListOfLendedProducts() {
        return listOfLendedProducts;
    }

    public void addLendedProduct(LibraryProduct libraryProduct) {
        listOfLendedProducts.add(libraryProduct);
    }

    public void addAvailableProduct(LibraryProduct libraryProduct) {
        listOfAvailableProducts.add(libraryProduct);
    }

    public LibraryProduct getLendedProductByName(String name) {
        LibraryProduct lendedProduct = null;
        for (LibraryProduct libraryProduct : listOfLendedProducts) {
            if (libraryProduct.getName().equalsIgnoreCase(name)) {
                lendedProduct = libraryProduct;
            }
        }
        return lendedProduct;
    }

    public LibraryProduct getListOfAvailableProductByName(String name) {
        LibraryProduct availableProduct = null;
        for (LibraryProduct libraryProduct : listOfAvailableProducts) {
            if(libraryProduct.getName().equalsIgnoreCase(name)) {
                availableProduct = libraryProduct;
            }
        }
         return availableProduct;
    }

    public ArrayList<User> getListOfUsers() {
        return listOfUsers;
    }
}
